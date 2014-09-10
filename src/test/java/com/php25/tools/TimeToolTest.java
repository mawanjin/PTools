package com.php25.tools;

import org.junit.Test;

import java.util.Date;

/**
 * Created by jack on 2014/8/14.
 */
public class TimeToolTest {
    @Test
    public void test() {
        System.out.println(TimeTool.getCurrentTimeInString());
        System.out.println(TimeTool.getCurrentTimeInLong());
        System.out.println(TimeTool.getTime(new Date()));

        System.out.println(TimeTool.getTime(TimeTool.getBeginTimeOfDay(new Date())));
        System.out.println(TimeTool.getTime(TimeTool.getEndTimeOfDay(new Date())));
        System.out.println(TimeTool.getTime(TimeTool.offsiteDay(new Date(), -1)));
        System.out.println(TimeTool.getTime(TimeTool.offsiteWeek(new Date(), -1)));
        System.out.println(TimeTool.getTime(TimeTool.offsiteMonth(new Date(), -1)));
    }
}
