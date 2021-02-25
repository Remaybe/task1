import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {

    private String studentName, curriculum;
    private Date startDate;
    List<Course> courseList = new ArrayList<Course>();

    public Student(String studentName, String curriculum, Date startDate) {
        this.studentName = studentName;
        this.curriculum = curriculum;
        this.startDate = startDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
