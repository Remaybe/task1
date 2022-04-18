import org.testng.annotations.BeforeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class BaseTest {

    public static Student student;
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static final int EARLIER_DATE_MARK = -1;

    @BeforeTest
    public void setStudentsData() throws ParseException {
        student = Student.builder()
                .studentName("Ivanov Fedor")
                .curriculum("Java Developer")
                .startDate(FORMATTER.parse("16 April 2022, Friday, 10:00"))
                .build();
        student.chooseCourse(CourseOrder.JAVA);
        student.chooseCourse(CourseOrder.JDBC);
        student.chooseCourse(CourseOrder.SPRING);
    }
}
