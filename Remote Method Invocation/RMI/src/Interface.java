import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Remote;
public interface Interface extends Remote {

    default String checkOverbook(String CID, String courseSection,DataBase dataBase) throws RemoteException {
        return null;
    }

    default DataBase register(String SID, String CID, String courseSection, DataBase dataBase ) throws RemoteException {
        return null;
    }
    default String listAllCourse(DataBase dataBase) throws RemoteException {
        return null;
    }

    default String log(String data) throws RemoteException {
        return null;
    }
    default String checkConflict(String SID, String CID, String courseSection, DataBase dataBase) throws RemoteException {
        return null;
    }

    default String listCourseRegistered (String CID,String courseSection, DataBase dataBase) throws RemoteException{
        return null;
    }


    default String listCourseCompleted(String SID, DataBase dataBase) throws RemoteException {
        return null;
    }

    default String listCoursesStudentRegisterFor(String SID,DataBase dataBase) throws RemoteException{
        return null;
    }

    default String listAllStudent(DataBase dataBase) throws RemoteException{
        return null;
    }



}
