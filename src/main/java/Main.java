public class Main {

    public static final StudentsData STUDENTS_DATA = new StudentsData();

    public static void main(String[] args) {

        Student firstStudent = new Student("Ivanov Fedor", "Java Developer",
                STUDENTS_DATA.inputDate("1 June 2020, Monday, 10:00"));
        firstStudent.chooseCourse(CourseOrder.JAVA);
        firstStudent.chooseCourse(CourseOrder.JDBC);
        firstStudent.chooseCourse(CourseOrder.SPRING);

        Student secondStudent = new Student("Sidorov Ivan", "AQE",
                STUDENTS_DATA.inputDate("8 June 2020, Monday, 10:00"));
        secondStudent.chooseCourse(CourseOrder.TEST_DESIGN);
        secondStudent.chooseCourse(CourseOrder.PAGE_OBJECT);
        secondStudent.chooseCourse(CourseOrder.SELENIUM);

        STUDENTS_DATA.getStats(firstStudent, true);
        STUDENTS_DATA.getStats(secondStudent, true);



    }
}
