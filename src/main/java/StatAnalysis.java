import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StatAnalysis {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static final Date TODAY_DATE = new Date();
    public static final long MILLISECONDS_PER_DAY = 86400000;
    public static final long MILLISECONDS_PER_HOUR = 3600000;
    public static final int WORKING_HOURS_PER_DAY = 8;

    public static Date getEndDate(Student student) {
        try {
            return FORMATTER.parse(getTextEndDate(student.getStartDate(), getDurationSum(student.courseList)));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getTextEndDate(Date date, int durationSum) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        while (durationSum >= WORKING_HOURS_PER_DAY) {
            if (FORMATTER.format(c.getTime()).contains("Saturday") || FORMATTER.format(c.getTime()).contains("Sunday"))
                c.add(Calendar.DATE, 1);
            else {
                c.add(Calendar.DATE, 1);
                durationSum -= WORKING_HOURS_PER_DAY;
            }
        }
        if (durationSum != 0) c.add(Calendar.HOUR_OF_DAY, durationSum);
        else {
            c.add(Calendar.DATE, -1);
            c.add(Calendar.HOUR_OF_DAY, 8);
        }
        return FORMATTER.format(c.getTime());
    }

    public static int getDurationSum(List<Course> courseList) {
        return courseList.stream().mapToInt(Course::getCourseDuration).sum();
    }

    public static String getHowMuchRemains(Date dateEnd) {
        long delt, days, hours;
        String result = null;
        if (dateEnd.getTime() > TODAY_DATE.getTime()) delt = dateEnd.getTime() - TODAY_DATE.getTime();
        else delt = TODAY_DATE.getTime() - dateEnd.getTime();
        days = delt / MILLISECONDS_PER_DAY;
        hours = (delt % MILLISECONDS_PER_DAY) / MILLISECONDS_PER_HOUR;
        if (days != 0) result = days + " d ";
        if (hours != 0) result += hours + " hours";
        if (dateEnd.getTime() > TODAY_DATE.getTime())
            return "Training is not finished. \n" + result + " are left until the end.";
        else return "Training completed. \n" + result + " have passed after the end.";
    }
}