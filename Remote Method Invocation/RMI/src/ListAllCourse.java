import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ListAllCourse extends UnicastRemoteObject implements Interface {


    protected ListAllCourse() throws RemoteException {
    }

    @Override
    public String listAllCourse(DataBase dataBase) throws RemoteException {
        ArrayList<Course> vCourse = dataBase.getAllCourseRecords();
        StringBuilder result = new StringBuilder();

        // Iterate over the course records
        for (Course course : vCourse) {
            // Append the string representation of each course to the result
            result.append(course.toString()).append("\n");
        }

        // Return the concatenated string
        return result.toString();
    }

}
