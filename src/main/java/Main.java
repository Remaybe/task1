import java.util.Arrays;

public class Main {

    static StudentsData studentsData = new StudentsData();

    public static void main(String[] args) {

        Student firstStudent = Student.builder()
                .studentName("Ivanov Fedor")
                .curriculum("Java Developer")
                .startDate(studentsData.setDate("1 June 2020, Monday, 10:00"))
                .build();
        firstStudent.chooseCourse(CourseOrder.JAVA);
        firstStudent.chooseCourse(CourseOrder.JDBC);
        firstStudent.chooseCourse(CourseOrder.SPRING);

        Student secondStudent = Student.builder()
                .studentName("Sidorov Ivan")
                .curriculum("AQE")
                .startDate(studentsData.setDate("8 June 2020, Monday, 10:00"))
                .build();
        secondStudent.chooseCourse(CourseOrder.TEST_DESIGN);
        secondStudent.chooseCourse(CourseOrder.PAGE_OBJECT);
        secondStudent.chooseCourse(CourseOrder.SELENIUM);

        studentsData.getStats(firstStudent, true);
        studentsData.getStats(secondStudent, true);

    }
}
