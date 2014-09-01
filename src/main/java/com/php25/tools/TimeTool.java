package com.php25.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jack on 2014/9/1.
 */
public interface TimeTool {
    /**
     * 把时间戳转成字符串
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public String getTime(long timeInMillis, SimpleDateFormat dateFormat);
    /**
     * 把日期转成字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public  String getTime(Date date, SimpleDateFormat dateFormat);

    /**
     * 把时间戳转成字符串，用默认的格式
     *
     * @param timeInMillis
     * @return
     */
    public  String getTime(long timeInMillis);

    /**
     * 把日期转成字符串，用默认的格式
     *
     * @param date
     * @return
     */
    public  String getTime(Date date);

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public  long getCurrentTimeInLong();

    /**
     * 获取当前时间，字符串格式，默认的格式
     *
     * @return
     */
    public  String getCurrentTimeInString();

    /**
     * 获取当前时间，字符串形式
     *
     * @param dateFormat
     * @return
     */
    public  String getCurrentTimeInString(SimpleDateFormat dateFormat);

    /**
     * 获取某天的开始时间
     *
     * @param date 日期
     * @return 某天的开始时间
     */
    public  Date getBeginTimeOfDay(Date date);

    /**
     * 获取某天的结束时间
     *
     * @param date 日期
     * @return 某天的结束时间
     */
    public  Date getEndTimeOfDay(Date date);

    /**
     * 偏移天
     *
     * @param date    日期
     * @param offsite 偏移天数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public  Date offsiteDay(Date date, int offsite);

    /**
     * 偏移周
     *
     * @param date    日期
     * @param offsite 偏移周数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public  Date offsiteWeek(Date date, int offsite);

    /**
     * 偏移月
     *
     * @param date    日期
     * @param offsite 偏移月数，正数向未来偏移，负数向历史偏移
     * @return 偏移后的日期
     */
    public  Date offsiteMonth(Date date, int offsite);

    /**
     * 获取指定日期偏移指定时间后的时间
     *
     * @param date          基准日期
     * @param calendarField 偏移的粒度大小（小时、天、月等）使用Calendar中的常数
     * @param offsite       偏移量，正数为向后偏移，负数为向前偏移
     * @return 偏移后的日期
     */
    public  Date offsiteDate(Date date, int calendarField, int offsite);
}
