import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {

    private String courseName;
    private int courseDuration;

    @Override
    public String toString() {
        System.out.print(courseDuration);
        System.out.format("%30s", courseName);
        return "\n";
    }
}