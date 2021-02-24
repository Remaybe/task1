import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static void main(String[] args) {

        Date date = new Date();

        String strDate = "1 June 2020, Monday, 10:00";

        try {
            date = formatter.parse(strDate);
        }
        catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }

        Student firstStudent = new Student("Ivanov Ivan", "Java Developer", "Java", "JDBC", "Spring", date, 16, 24, 16);
        int durationSum = firstStudent.getCourseDuration1() + firstStudent.getCourseDuration2() + firstStudent.getCourseDuration3();
        String endDate = getEndDate(date, durationSum);
        System.out.println(endDate);



    }

    public static String getEndDate(Date date, int durationSum) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        while (durationSum >= 8) {
            if (formatter.format(c.getTime()).contains("Saturday") || formatter.format(c.getTime()).contains("Sunday")) c.add(Calendar.DATE, 1); else {
                c.add(Calendar.DATE, 1);
                durationSum -= 8;
            }
        }
        c.add(Calendar.HOUR_OF_DAY, durationSum);
        return formatter.format(c.getTime());
    }
}
