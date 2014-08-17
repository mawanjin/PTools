package com.php25;

import org.junit.Test;

import java.util.Date;

/**
 * Created by jack on 2014/8/14.
 */
public class TimeUtilsTest {
    @Test
    public void test() {
        System.out.println(TimeUtils.getCurrentTimeInString());
        System.out.println(TimeUtils.getCurrentTimeInLong());
        System.out.println(TimeUtils.getTime(new Date()));

        System.out.println(TimeUtils.getTime(TimeUtils.getBeginTimeOfDay(new Date())));
        System.out.println(TimeUtils.getTime(TimeUtils.getEndTimeOfDay(new Date())));
        System.out.println(TimeUtils.getTime(TimeUtils.offsiteDay(new Date(),-1)));
        System.out.println(TimeUtils.getTime(TimeUtils.offsiteWeek(new Date(),-1)));
        System.out.println(TimeUtils.getTime(TimeUtils.offsiteMonth(new Date(),-1)));
    }
}
