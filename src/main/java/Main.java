import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Main {

    static StudentsData studentsData = new StudentsData();
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {

        Student firstStudent = Student.builder()
                .studentName("Ivanov Fedor")
                .curriculum("Java Developer")
                .startDate(FORMATTER.parse("3 September 2020, Thursday, 10:00"))
                .build();
        firstStudent.chooseCourse(CourseOrder.JAVA);
        firstStudent.chooseCourse(CourseOrder.JDBC);
        firstStudent.chooseCourse(CourseOrder.SPRING);

        Student secondStudent = Student.builder()
                .studentName("Sidorov Ivan")
                .curriculum("AQE")
                .startDate(FORMATTER.parse("8 June 2020, Monday, 10:00"))
                .build();
        secondStudent.chooseCourse(CourseOrder.TEST_DESIGN);
        secondStudent.chooseCourse(CourseOrder.PAGE_OBJECT);
        secondStudent.chooseCourse(CourseOrder.SELENIUM);

        studentsData.getStats(firstStudent, true);
        studentsData.getStats(secondStudent, true);

    }
}
