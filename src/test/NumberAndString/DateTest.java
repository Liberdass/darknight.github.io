package test.NumberAndString;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        String day = sdf.format(date);
        c.setTime(date);
        System.out.println(sdf.format(c.getTime()));
        c.add(Calendar.YEAR,-1);
        System.out.println(sdf.format(c.getTime()));
        c.add(Calendar.MONTH,1);
        c.set(Calendar.DAY_OF_MONTH,5);
        System.out.println(sdf.format(c.getTime()));
    }
}
