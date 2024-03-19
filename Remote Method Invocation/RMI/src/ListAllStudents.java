import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ListAllStudents extends UnicastRemoteObject implements Interface {

    protected ListAllStudents() throws RemoteException {
    }

    @Override
    public String listAllStudent(DataBase dataBase) throws RemoteException {
        ArrayList<Student> vStudent = dataBase.getAllStudentRecords();
        StringBuilder result = new StringBuilder();

        // Iterate over the student records
        for (Student student : vStudent) {
            // Append the string representation of each student to the result
            result.append(student.toString()).append("\n");
        }

        // Return the concatenated string
        return result.toString();


    }
}
