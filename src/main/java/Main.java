public class Main {

    public static final StudentsData studentsData = new StudentsData();

    public static void main(String[] args) {

        Student firstStudent = new Student("Ivanov Fedor", "Java Developer",
                studentsData.inputDate("1 June 2020, Monday, 10:00"));
        firstStudent.courseList.add(new Course("Java", 16));
        firstStudent.courseList.add(new Course("JDBC", 24));
        firstStudent.courseList.add(new Course("Spring", 16));

        studentsData.getStats(firstStudent, false);

    }
}
