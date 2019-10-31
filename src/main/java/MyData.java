import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyData {
    public String dataPlus() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDaysLater = calendar.getTime();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat(" dd.MM.yyyy");
        String dayPlus3 = formatForDateNow.format(threeDaysLater);
        return dayPlus3;
    }
}
