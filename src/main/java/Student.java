import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class Student {

    private String studentName, curriculum;
    private Date startDate;

    @Builder.Default
    List<Course> courseList = new ArrayList<>();

    public void chooseCourse(CourseOrder courseOrder){
        switch (courseOrder){
            case JAVA:
                courseList.add(new Course("Java", 16));
                break;
            case JDBC:
                courseList.add(new Course("JDBC", 24));
                break;
            case SPRING:
                courseList.add(new Course("Spring", 16));
                break;
            case SELENIUM:
                courseList.add(new Course("Test Design", 10));
                break;
            case PAGE_OBJECT:
                courseList.add(new Course("Page Object", 16));
                break;
            case TEST_DESIGN:
                courseList.add(new Course("Selenium", 16));
                break;
            default:
                break;
        }
    }
}