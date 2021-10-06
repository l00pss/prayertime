package org.namazvaxti.prayertimews.dataAccess.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayHelper {
    private static Calendar gregorianCalendar;
    private static Integer DAY_OF_YEAR;

    public static Integer getDayOfYear(){
        gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        return gregorianCalendar.get(Calendar.DAY_OF_YEAR)-1;
    }
    public static Integer getCountOfYear(){
        return 365;
    }
}
