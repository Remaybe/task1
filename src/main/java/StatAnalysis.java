import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StatAnalysis {

    public static final SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static final Date todayDate = new Date();
    public static final long numberOfMillisecondsPerYear = 86400000;
    public static final long numberOfMillisecondsPerHour = 3600000;
    public static final int numberOfWorkingHoursPerDay = 8;

    public static String getEndDate(Date date, int durationSum) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        while (durationSum >= numberOfWorkingHoursPerDay) {
            if (formatter.format(c.getTime()).contains("Saturday") || formatter.format(c.getTime()).contains("Sunday"))
                c.add(Calendar.DATE, 1);
            else {
                c.add(Calendar.DATE, 1);
                durationSum -= numberOfWorkingHoursPerDay;
            }
        }
        c.add(Calendar.HOUR_OF_DAY, durationSum);
        return formatter.format(c.getTime());
    }

    public static int getDurationSum(List<Course> courseList) {
        int durationSum = 0;
        for (int i = 0; i < courseList.size(); i++) {
            durationSum += courseList.get(i).getCourseDuration();
        }
        return durationSum;

    }

    public static String howMuchRemains(Date date, Date dateEnd) {
        long delt, days, hours;
        String result = null;
        if (dateEnd.getTime() > todayDate.getTime()) delt = dateEnd.getTime() - date.getTime();
        else delt = todayDate.getTime() - dateEnd.getTime();
        days = delt / numberOfMillisecondsPerYear;
        hours = (delt % numberOfMillisecondsPerYear) / numberOfMillisecondsPerHour;
        if (days != 0) result = days + " d ";
        if (hours != 0) result += hours + " hours";
        if (dateEnd.getTime() > todayDate.getTime())
            result = "Training is not finished. " + result + " are left until the end.";
        else result = "Training completed. " + result + " have passed after the end.";
        return result;
    }

}
