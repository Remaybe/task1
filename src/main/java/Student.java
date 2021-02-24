import java.util.Date;

public class Student {



    private String studentName, curriculum, course1, course2, course3;
    private Date startDate;
    private int courseDuration1, courseDuration2, courseDuration3;

    public Student(String studentName, String curriculum, String course1, String course2, String course3, Date startDate, int courseDuration1, int courseDuration2, int courseDuration3) {
        this.studentName = studentName;
        this.curriculum = curriculum;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.startDate = startDate;
        this.courseDuration1 = courseDuration1;
        this.courseDuration2 = courseDuration2;
        this.courseDuration3 = courseDuration3;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getCourseDuration1() {
        return courseDuration1;
    }

    public void setCourseDuration1(int courseDuration1) {
        this.courseDuration1 = courseDuration1;
    }

    public int getCourseDuration2() {
        return courseDuration2;
    }

    public void setCourseDuration2(int courseDuration2) {
        this.courseDuration2 = courseDuration2;
    }

    public int getCourseDuration3() {
        return courseDuration3;
    }

    public void setCourseDuration3(int courseDuration3) {
        this.courseDuration3 = courseDuration3;
    }
}
