import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StudentsData {

    public static StatAnalysis statAnalysis = new StatAnalysis();
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static Date date = new Date();

    public Date setDate(String strDate) {
        try {
            date = FORMATTER.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        return date;
    }

    private void getFullStats(Student student){
        System.out.println("--------------------------------" + "\nSTUDENT NAME: " + student.getStudentName() +
                "\nWORKING TIME: From 10 to 18" + "\nPROGRAM NAME: " + student.getCurriculum() + "\n");
        System.out.printf("DURATION");
        System.out.format("%24s", "COURSE");
        System.out.println("\n--------------------------------");
        for (Course s : student.courseList) {
            System.out.print(s);
        }
        System.out.println("\nTOTAL HOURS: " + statAnalysis.getTotalHours(student) + "\nSTART DATE: " +
                FORMATTER.format(student.getStartDate()) + "\nEND DATE: " +
                statAnalysis.getTextEndDate(student.getStartDate(), statAnalysis.getTotalHours(student)) + "\nPROGRESS: " +
                statAnalysis.getHowMuchRemains(student.getStartDate(), statAnalysis.getEndDate(student)));
    }

    private void getShortStats(Student student){
        System.out.println("--------------------------------\n" + student.getStudentName() + " (" + student.getCurriculum()
                + ") - " + statAnalysis.getHowMuchRemains(student.getStartDate(), statAnalysis.getEndDate(student)));
    }

    public void getStats(Student student, boolean check) {
        if (check == false) getShortStats(student);
        else getFullStats(student);
    }
}
