import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class StudentsData {

    public static StatAnalysis statAnalysis = new StatAnalysis();
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);

    private void getFullStats(Student student) throws ParseException {
        System.out.println("--------------------------------" + "\nSTUDENT NAME: " + student.getStudentName() +
                "\nWORKING TIME: From 10 to 18" + "\nPROGRAM NAME: " + student.getCurriculum() + "\n");
        System.out.printf("DURATION")
                .format("%24s", "COURSE")
                .println("\n--------------------------------");
        student.courseList.stream().forEach(value -> System.out.print(value));
        System.out.println("\nTOTAL HOURS: " + statAnalysis.getDurationSum(student.courseList) + "\nSTART DATE: " +
                FORMATTER.format(student.getStartDate()) + "\nEND DATE: " +
                statAnalysis.getTextEndDate(student.getStartDate(), statAnalysis.getDurationSum(student.courseList)) + "\nPROGRESS: " +
                statAnalysis.getHowMuchRemains(student.getStartDate(), statAnalysis.getEndDate(student)));
    }

    private void getShortStats(Student student) throws ParseException {
        System.out.println("--------------------------------\n" + student.getStudentName() + " (" + student.getCurriculum()
                + ") - " + statAnalysis.getHowMuchRemains(student.getStartDate(), statAnalysis.getEndDate(student)));
    }

    public void getStats(Student student, boolean check) throws ParseException {
        if (!check) getShortStats(student);
        else getFullStats(student);
    }
}