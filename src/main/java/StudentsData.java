import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StudentsData {

    public static StatAnalysis statAnalysis = new StatAnalysis();
    public static final SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static Date date = new Date();

    public Date inputDate(String strDate) {
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        return date;
    }

    public void getStats(Student firstStudent, boolean check) {
        Date dateEnd = new Date();
        int totalHours = statAnalysis.getDurationSum(firstStudent.courseList);
        try {
            dateEnd = formatter.parse(statAnalysis.getEndDate(firstStudent.getStartDate(), totalHours));
        } catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        if (check == false)
            System.out.println(firstStudent.getStudentName() + " (" + firstStudent.getCurriculum() + ") - " + statAnalysis.howMuchRemains(firstStudent.getStartDate(), dateEnd));
        else {
            System.out.println("STUDENT NAME: " + firstStudent.getStudentName() + "\nWORKING TIME: From 10 to 18" +
                    "\nPROGRAM NAME: " + firstStudent.getCurriculum() + "\n PROGRAM DURATION:");
            for (Course s : firstStudent.courseList) {
                System.out.println(s);
            }
            System.out.println("TOTAL HOURS: " + totalHours + "\nSTART DATE: " +
                    formatter.format(firstStudent.getStartDate()) + "\nEND DATE: " +
                    statAnalysis.getEndDate(firstStudent.getStartDate(), totalHours) + "\n PROGRESS:\n" +
                    statAnalysis.howMuchRemains(firstStudent.getStartDate(), dateEnd));
        }
    }
}
