package experiment.random;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created 7/24/2017 13:13
 *
 * @author Deepankar Sharma
 */
public class DateTest {

  public static void main(String[] args) {
    //System.out.println(new Date(System.currentTimeMillis()));
    System.out.println(toMidnightOfDate(new Date(System.currentTimeMillis())));
    System.out.println(getFutureDate(1,8,0));
    System.out.println(getFutureDate(1,24,0));
  }

  public static Date toMidnightOfDate(Date date) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  static Date getFutureDate(int days, int hours, int minutes) {
    Calendar calendar = new GregorianCalendar();
    calendar.add(Calendar.DAY_OF_YEAR, days);
    calendar.set(Calendar.HOUR_OF_DAY, hours);
    calendar.set(Calendar.MINUTE, minutes);
    return calendar.getTime();
  }

}
