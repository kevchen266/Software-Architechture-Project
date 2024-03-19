import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a registry on port 1099
            Registry registry = LocateRegistry.createRegistry(2011);

            // Bind remote objects to registry with unique names
            registry.rebind("ListAllStudents",new ListAllStudents());
            registry.rebind("ListAllCourse", new ListAllCourse());
            registry.rebind("Logger", new Logger());
            registry.rebind("ListCourseCompleted", new ListCourseCompleted());
            registry.rebind("ListCourseRegistered",new ListCourseRegistered());
            registry.rebind("ListCourseStudentRegister",new ListCourseStudentRegister());
            registry.rebind("StudentRegistration",new StudentRegistration());
            registry.rebind("CourseConflict",new CourseConflict());
            registry.rebind("CourseOverbookMonitor",new CourseOverbook());

            System.out.println("Server running.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}