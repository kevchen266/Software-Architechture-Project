import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CourseConflict extends UnicastRemoteObject implements Interface {
    protected CourseConflict() throws RemoteException {
    }

    @Override
    public String checkConflict(String SID, String CID, String courseSection, DataBase dataBase) throws RemoteException {

        Student studentRecord = dataBase.getStudentRecord(SID);
        Course courseRecord = dataBase.getCourseRecord(CID, courseSection);
        String status = "noConflict";

        if (studentRecord == null) {
            return "Invalid student ID";
        }
        if (courseRecord == null) {
            return "Invalid course ID or course section";
        }

        ArrayList<Course> registeredCourses = studentRecord.getRegisteredCourses();

        for (Course registeredCourse : registeredCourses) {
            if (registeredCourse.conflicts(courseRecord)) {
                status = "conflict";
                break;
            }
        }

        return status;
    }

}
