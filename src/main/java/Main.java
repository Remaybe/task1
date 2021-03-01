public class Main {


    public static void main(String[] args) {

        StudentsData studentsData = new StudentsData();

        Student firstStudent = new Student("Ivanov Fedor", "Java Developer",
                studentsData.setDate("1 June 2020, Monday, 10:00"));
        firstStudent.chooseCourse(CourseOrder.JAVA);
        firstStudent.chooseCourse(CourseOrder.JDBC);
        firstStudent.chooseCourse(CourseOrder.SPRING);

        Student secondStudent = new Student("Sidorov Ivan", "AQE",
                studentsData.setDate("8 June 2020, Monday, 10:00"));
        secondStudent.chooseCourse(CourseOrder.TEST_DESIGN);
        secondStudent.chooseCourse(CourseOrder.PAGE_OBJECT);
        secondStudent.chooseCourse(CourseOrder.SELENIUM);

        studentsData.getStats(firstStudent, true);
        studentsData.getStats(secondStudent, true);



    }
}
