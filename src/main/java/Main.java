import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Main {

    public static final SimpleDateFormat formatter = new SimpleDateFormat("d MMMM yyyy, EEEE, HH:mm", Locale.ENGLISH);
    public static final Date todayDate = new Date();
    public static final long numberOfMillisecondsPerYear = 86400000;
    public static final long numberOfMillisecondsPerHour = 3600000;
    public static final int numberOfWorkingHoursPerDay = 8;



    public static void main(String[] args) {

        Date date = new Date();
        String strDate = "1 June 2020, Monday, 10:00";
        try {
            date = formatter.parse(strDate);
        }
        catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }

        Student firstStudent = new Student("Ivanov Fedor", "Java Developer", date);
        firstStudent.courseList.add(new Course("Java", 16));
        firstStudent.courseList.add(new Course("JDBC", 24));
        firstStudent.courseList.add(new Course("Spring", 16));

        getStats(firstStudent, true);


    }

    public static String getEndDate(Date date, int durationSum) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        while (durationSum >= numberOfWorkingHoursPerDay) {
            if (formatter.format(c.getTime()).contains("Saturday") || formatter.format(c.getTime()).contains("Sunday")) c.add(Calendar.DATE, 1);
            else {
                c.add(Calendar.DATE, 1);
                durationSum -= numberOfWorkingHoursPerDay;
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
        days = delt / numberOfMillisecondsPerYear;
        hours = (delt % numberOfMillisecondsPerYear) / numberOfMillisecondsPerHour;
        if (days != 0) result = days + " d ";
        if (hours != 0) result += hours + " hours";
        if (dateEnd.getTime() > todayDate.getTime()) result = "Training is not finished. " + result + " are left until the end.";
        else result = "Training completed. " + result + " have passed after the end.";
        return result;
    }

    public static void getStats (Student firstStudent, boolean check) {
        Date dateEnd = new Date();
        int totalHours =  getDurationSum(firstStudent.courseList);
        try {
            dateEnd = formatter.parse(getEndDate(firstStudent.getStartDate(), totalHours));
        }
        catch (ParseException e) {
            System.out.println("Invalid Data Format");
        }
        if (check == false) System.out.println(firstStudent.getStudentName() + " (" + firstStudent.getCurriculum() + ") - " + howMuchRemains(firstStudent.getStartDate(),dateEnd));
        else {
            System.out.println("STUDENT NAME: " + firstStudent.getStudentName() + "\nWORKING TIME: From 10 to 18" +
                    "\nPROGRAM NAME: " + firstStudent.getCurriculum() + "\n PROGRAM DURATION:");
            for(Course s : firstStudent.courseList) {
                System.out.println(s);
            }
            System.out.println("TOTAL HOURS: " + totalHours + "\nSTART DATE: " +
                    formatter.format(firstStudent.getStartDate()) + "\nEND DATE: " +
                    getEndDate(firstStudent.getStartDate(), totalHours) + "\n PROGRESS:\n" +
                    howMuchRemains(firstStudent.getStartDate(), dateEnd));
        }
        }

    public static int getDurationSum(List<Course> courseList){
        int durationSum = 0;
        for (int i = 0; i < courseList.size(); i++){
            durationSum += courseList.get(0).getCourseDuration();
        }
        return durationSum;

    }
    }
