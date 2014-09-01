package com.php25.tools.impl;

import com.php25.tools.TimeTool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jack on 2014/8/13.
 */
public class TimeToolImpl implements TimeTool{
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");


    public  String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }


    public  String getTime(Date date, SimpleDateFormat dateFormat) {
        return dateFormat.format(date);
    }


    public  String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }


    public  String getTime(Date date) {
        return getTime(date, DEFAULT_DATE_FORMAT);
    }


    public  long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }


    public  String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }


    public  String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }


    public  Date getBeginTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public  Date getEndTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }


    public  Date offsiteDay(Date date, int offsite) {
        return offsiteDate(date, Calendar.DAY_OF_YEAR, offsite);
    }


    public  Date offsiteWeek(Date date, int offsite) {
        return offsiteDate(date, Calendar.WEEK_OF_YEAR, offsite);
    }


    public  Date offsiteMonth(Date date, int offsite) {
        return offsiteDate(date, Calendar.MONTH, offsite);
    }


    public  Date offsiteDate(Date date, int calendarField, int offsite) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(calendarField, offsite);
        return cal.getTime();
    }
}
