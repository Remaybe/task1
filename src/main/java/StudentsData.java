import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StudentsData {

    public static StatAnalysis statAnalysis = new StatAnalysis();
    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static Date date = new Date();

    public Date inputDate(String strDate) {
        try {
            date = FORMATTER.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        return date;
    }

    public void getStats(Student firstStudent, boolean check) {
        Date dateEnd = new Date();
        int totalHours = statAnalysis.getDurationSum(firstStudent.courseList);
        try {
            dateEnd = FORMATTER.parse(statAnalysis.getEndDate(firstStudent.getStartDate(), totalHours));
        } catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        if (check == false)
            System.out.println("--------------------------------\n" + firstStudent.getStudentName() + " (" + firstStudent.getCurriculum()
                    + ") - " + statAnalysis.howMuchRemains(firstStudent.getStartDate(), dateEnd));
        else {
            System.out.println("--------------------------------" + "\nSTUDENT NAME: " + firstStudent.getStudentName() +
                    "\nWORKING TIME: From 10 to 18" + "\nPROGRAM NAME: " + firstStudent.getCurriculum() + "\n");
            System.out.printf("DURATION");
            System.out.format("%24s", "COURSE");
            System.out.println("\n--------------------------------");
            for (Course s : firstStudent.courseList) {
                System.out.print(s);
            }
            System.out.println("\nTOTAL HOURS: " + totalHours + "\nSTART DATE: " +
                    FORMATTER.format(firstStudent.getStartDate()) + "\nEND DATE: " +
                    statAnalysis.getEndDate(firstStudent.getStartDate(), totalHours) + "\nPROGRESS: " +
                    statAnalysis.howMuchRemains(firstStudent.getStartDate(), dateEnd));
        }
    }
}
