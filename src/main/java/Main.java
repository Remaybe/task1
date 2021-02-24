import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static Date todayDate = new Date();

    public static void main(String[] args) {

        Date date = new Date();
        String strDate = "1 June 2020, Monday, 10:00";
        try {
            date = formatter.parse(strDate);
        }
        catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        Student firstStudent = new Student("Ivanov Fedor", "Java Developer", "Java",
                "JDBC", "Spring", date, 16, 24, 16);

        getStats(firstStudent, false);
    }

    public static String getEndDate(Date date, int durationSum) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        while (durationSum >= 8) {
            if (formatter.format(c.getTime()).contains("Saturday") || formatter.format(c.getTime()).contains("Sunday")) c.add(Calendar.DATE, 1);
            else {
                c.add(Calendar.DATE, 1);
                durationSum -= 8;
            }
        }
        c.add(Calendar.HOUR_OF_DAY, durationSum);
        return formatter.format(c.getTime());
    }

    public static String howMuchRemains (Date date, Date dateEnd) {
        long delt, days, hours;
        String result = null;
        if (dateEnd.getTime() > todayDate.getTime()) delt = dateEnd.getTime() - date.getTime();
        else delt = todayDate.getTime() - dateEnd.getTime();
        days = delt / 86400000;
        hours = (delt % 86400000) / 3600000;
        if (days != 0) result = days + " d ";
        if (hours != 0) result += hours + " hours";
        if (dateEnd.getTime() > todayDate.getTime()) result = "Training is not finished. " + result + " are left until the end.";
        else result = "Training completed. " + result + " have passed after the end.";
        return result;
    }

    public static void getStats (Student firstStudent, boolean check) {
        Date dateEnd = new Date();
        int totalHours = firstStudent.getCourseDuration1() + firstStudent.getCourseDuration2() + firstStudent.getCourseDuration3();
        try {
            dateEnd = formatter.parse(getEndDate(firstStudent.getStartDate(), totalHours));
        }
        catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        if (check == false) System.out.println(firstStudent.getStudentName() + " (" + firstStudent.getCurriculum() + ") - " + howMuchRemains(firstStudent.getStartDate(),dateEnd));
        else System.out.println("STUDENT NAME: " + firstStudent.getStudentName() + "\nWORKING TIME: From 10 to 18" +
                    "\nPROGRAM NAME: " + firstStudent.getCurriculum() + "\n PROGRAM DURATION:\n" +
                    firstStudent.getCourse1() + " - " + firstStudent.getCourseDuration1() + " hours \n" +
                    firstStudent.getCourse2() + " - " + firstStudent.getCourseDuration2() + " hours \n" +
                    firstStudent.getCourse3() + " - " + firstStudent.getCourseDuration3() + " hours \nTOTAL HOURS: " +
                    totalHours + "\nSTART DATE: " + formatter.format(firstStudent.getStartDate()) + "\nEND DATE: " +
                    getEndDate(firstStudent.getStartDate(), totalHours) + "\n PROGRESS:\n" +
                    howMuchRemains(firstStudent.getStartDate(), dateEnd));
        }
    }
