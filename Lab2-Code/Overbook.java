public class Overbook {
    public static final int OVERBOOK_LIMIT = 3;

    public static String getOverbookString(Course course) {
        int size = course.getRegisteredStudents().size();
        return size > Overbook.OVERBOOK_LIMIT ? " (Overbooked! Currently " + size + ")" : " (Currently " + size + ")";
    }
}
