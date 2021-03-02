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

    public int getTotalHours(Student student){
        int totalHours = getDurationSum(student.courseList);
        return totalHours;
    }

    public Date getEndDate(Student student){
        Date dateEnd = new Date();
        int totalHours = getDurationSum(student.courseList);
        try {
            dateEnd = FORMATTER.parse(getTextEndDate(student.getStartDate(), totalHours));
        } catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        return dateEnd;
    }

    public String getTextEndDate(Date date, int durationSum) {
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
        c.add(Calendar.HOUR_OF_DAY, durationSum);
        return FORMATTER.format(c.getTime());
    }


    public int getDurationSum(List<Course> courseList) {
        int durationSum = courseList.stream().mapToInt(Course::getCourseDuration).sum();
        return durationSum;
    }

    public String getHowMuchRemains(Date date, Date dateEnd) {
        long delt, days, hours;
        String result = null;
        if (dateEnd.getTime() > TODAY_DATE.getTime()) delt = dateEnd.getTime() - date.getTime();
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
