import org.testng.annotations.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest extends BaseTest{

    @Test(description = "Validate full student's data")
    public void getFullStudentsData(){
        StudentsData.getStats(student, true);
        String fullStats = StudentsData.getFullStats(student);
        assertThat(fullStats)
                .as("Logs contain invalid start date")
                .contains("START DATE: " + FORMATTER.format(student.getStartDate()));
        assertThat(fullStats)
                .as("Logs contain invalid end date")
                .contains("END DATE: " + StatAnalysis.getTextEndDate(student.getStartDate(), StatAnalysis.getDurationSum(student.getCourseList())));
        assertThat(fullStats)
                .as("Logs contain invalid total hours")
                .contains("TOTAL HOURS: " + StatAnalysis.getDurationSum(student.getCourseList()));
    }

    @Test(description = "Validate short student's data")
    public void getShortStudentsData(){
        StudentsData.getStats(student, false);
        String shortStats = StudentsData.getShortStats(student);
        assertThat(shortStats)
                .as("Logs contain invalid student's name")
                .contains(student.getStudentName());
        assertThat(shortStats)
                .as("Logs contain invalid program name")
                .contains(student.getCurriculum());
    }

    @Test(description = "Validate getHowMuchRemains function")
    public void validateGetHowMuchRemainsFunction(){
        boolean dateEquality = new Date().getTime() >= student.getStartDate().getTime();
        String expectedMessage = dateEquality ? "Training completed" : "Training is not finished";
        assertThat(StatAnalysis.getHowMuchRemains(student.getStartDate()))
                .as("Invalid training status, while expression 'today's date older or equal to student's start date' is " + dateEquality)
                .contains(expectedMessage);
    }

    @Test(description = "Validate comparison of course's dates")
    public void validateDatesComparison(){
        assertThat(student.getStartDate().compareTo(StatAnalysis.getEndDate(student)))
                .as("Start date couldn't be older then end date")
                .isEqualTo(EARLIER_DATE_MARK);
    }
}
