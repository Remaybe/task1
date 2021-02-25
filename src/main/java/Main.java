public class Main {

    public static final StudentsData studentsData = new StudentsData();

    public static void main(String[] args) {

        Student firstStudent = new Student("Ivanov Fedor", "Java Developer",
                studentsData.inputDate("1 June 2020, Monday, 10:00"));
        firstStudent.courseList.add(new Course("Java", 16));
        firstStudent.courseList.add(new Course("JDBC", 24));
        firstStudent.courseList.add(new Course("Spring", 16));

        Student secondStudent = new Student("Sidorov Ivan", "AQE",
                studentsData.inputDate("8 June 2020, Monday, 10:00"));
        firstStudent.courseList.add(new Course("Test Design", 10));
        firstStudent.courseList.add(new Course("Page Object", 16));
        firstStudent.courseList.add(new Course("Selenium", 16));

//        studentsData.getStats(firstStudent, false);
        studentsData.getStats(secondStudent, true);


    }
}
