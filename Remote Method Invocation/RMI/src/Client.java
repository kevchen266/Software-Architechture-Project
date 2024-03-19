import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {


        /*
        create log file if does not exist.
         */
        File logFile = new File("log.txt");
        if (logFile.exists()) {
            logFile.delete();
        }

        String SID;
        String CID;
        String courseSection;
        Registry registry = LocateRegistry.getRegistry("localhost", 2011);
        DataBase dataBase = new DataBase("Students.txt","Courses.txt");
        Scanner scanner = new Scanner(System.in);
        Interface logger = (Interface) registry.lookup("Logger");



        while (true) {
            System.out.println(logger.log("\nStudent Registration System\n"));
            System.out.println(logger.log("1) List all students"));
            System.out.println(logger.log("2) List all courses"));
            System.out.println(logger.log("3) List students who registered for a course"));
            System.out.println(logger.log("4) List courses a student has registered for"));
            System.out.println(logger.log("5) List courses a student has completed"));
            System.out.println(logger.log("6) Register a student for a course"));
            System.out.println(logger.log("x) Exit"));
            System.out.println(logger.log("\nEnter your choice and press return >> "));



            String command = scanner.next();
            switch (command) {


                case "1":
                    Interface ListAllStudents = (Interface) registry.lookup("ListAllStudents");
                    System.out.println(logger.log(ListAllStudents.listAllStudent(dataBase)));
                    break;
                case "2":
                    Interface ListAllCourse = (Interface) registry.lookup("ListAllCourse");
                    System.out.println(logger.log(ListAllCourse.listAllCourse(dataBase)));
                    break;
                case "3":
                    Interface ListCourseRegistered = (Interface) registry.lookup("ListCourseRegistered");
                    System.out.println(logger.log("Enter course ID and press return >> "));
                    CID = scanner.next();
                    System.out.println(logger.log("Enter course section and press return >> "));
                    courseSection = scanner.next();
                    System.out.println(logger.log(ListCourseRegistered.listCourseRegistered(CID,courseSection,dataBase)));
                    break;
                case "4":
                    Interface ListCourseStudentRegister = (Interface) registry.lookup("ListCourseStudentRegister");
                    System.out.println(logger.log("Enter student ID and press return >> "));
                    SID = scanner.next();
                    System.out.println(ListCourseStudentRegister.listCoursesStudentRegisterFor(SID,dataBase));
                    break;
                case "5":
                    Interface ListCourseCompleted = (Interface) registry.lookup("ListCourseCompleted");
                    System.out.println(logger.log("Enter student ID and press return >> "));
                    SID = scanner.next();
                    System.out.println(logger.log(ListCourseCompleted.listCourseCompleted(SID,dataBase)));
                    break;
                case "6":
                    Interface StudentRegistration = (Interface) registry.lookup("StudentRegistration");
                    Interface CourseConflict = (Interface) registry.lookup("CourseConflict");
                    Interface CourseOverbookMonitor = (Interface) registry.lookup("CourseOverbookMonitor");
                    System.out.println(logger.log("Enter student ID and press return >> "));
                    SID = scanner.next();
                    System.out.println(logger.log("Enter course ID and press return >> "));
                    CID = scanner.next();
                    System.out.println(logger.log("Enter course section and press return >> "));
                    courseSection = scanner.next();
                    String checkInfo = CourseConflict.checkConflict(SID, CID, courseSection, dataBase);
                    if (checkInfo.equals("noConflict")) {
                        dataBase = StudentRegistration.register(SID,CID,courseSection,dataBase);
                        System.out.println(logger.log(CourseOverbookMonitor.checkOverbook(CID,courseSection,dataBase)));
                        System.out.println(logger.log("Successfully!"));
                    }else
                    {
                        System.out.println(logger.log(checkInfo));
                    }
                    break;

                case "x":
                    return;

                default:
                    System.out.println(logger.log("Invalid command"));
                    break;
            }
        }
    }

}

