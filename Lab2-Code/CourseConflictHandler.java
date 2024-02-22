import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

/*
Part C : check whether the student current schedule has course conflict.
        return "------Registration conflicts------" is student has course conflict.
 */
public class CourseConflictHandler extends CommandEventHandler {

    public CourseConflictHandler(DataBase objDataBase, int iCommandEvCode, int iOutputEvCode) {
        super(objDataBase, iCommandEvCode, iOutputEvCode);

    }

    @Override
    protected String execute(String param) {


        StringTokenizer objTokenizer = new StringTokenizer(param);
        String sSID     = objTokenizer.nextToken();
        String sCID     = objTokenizer.nextToken();
        String sSection = objTokenizer.nextToken();

        Student objStudent = this.objDataBase.getStudentRecord(sSID);
        Course objCourse = this.objDataBase.getCourseRecord(sCID, sSection);

        // Check if the given course conflicts with any of the courses the student has registered.
        if (objStudent != null && objCourse != null)
        {
            ArrayList vCourse = objStudent.getRegisteredCourses();
            for (int i = 0; i < vCourse.size(); i++) {
                if (((Course) vCourse.get(i)).conflicts(objCourse)) {
                    // return string if conflict is detected.
                    return "------Registration conflicts------";
                }
            }
        }

        return param;
    }
}
