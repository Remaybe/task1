import java.text.SimpleDateFormat;
import java.util.Locale;

public class StudentsData {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);

    public static String getFullStats(Student student) {
        String listingCourses = "";
        for (Course course : student.courseList) {
            listingCourses +=  "\n" + course.getCourseDuration() + String.format("%30s", course.getCourseName());
        }
        return "--------------------------------" + "\nSTUDENT NAME: " + student.getStudentName() + "\nWORKING TIME: From 10 to 18"
                + "\nPROGRAM NAME: " + student.getCurriculum() + "\n\nDURATION" + String.format("%24s", "COURSE") + "\n--------------------------------"
                + listingCourses + "\n\nTOTAL HOURS: " + StatAnalysis.getDurationSum(student.courseList) + "\nSTART DATE: " +
                FORMATTER.format(student.getStartDate()) + "\nEND DATE: " + StatAnalysis.getTextEndDate(student.getStartDate(), StatAnalysis.getDurationSum(student.courseList))
                + "\nPROGRESS: " + StatAnalysis.getHowMuchRemains(StatAnalysis.getEndDate(student));
    }

    public static String getShortStats(Student student) {
        return "--------------------------------\n" + student.getStudentName() + " (" + student.getCurriculum()
                + ") - " + StatAnalysis.getHowMuchRemains(StatAnalysis.getEndDate(student));
    }

    public static void getStats(Student student, boolean check) {
        if (!check) System.out.println(getShortStats(student));
        else System.out.println(getFullStats(student));
    }
}