package com.php25.tools;

import com.php25.tools.factory.PToolsFactory;
import com.php25.tools.impl.TimeToolImpl;
import org.junit.Test;

import java.util.Date;

/**
 * Created by jack on 2014/8/14.
 */
public class TimeToolTest {
    private static TimeTool tool = PToolsFactory.getInstance().getTimeTool();

    @Test
    public void test() {
        System.out.println(tool.getCurrentTimeInString());
        System.out.println(tool.getCurrentTimeInLong());
        System.out.println(tool.getTime(new Date()));

        System.out.println(tool.getTime(tool.getBeginTimeOfDay(new Date())));
        System.out.println(tool.getTime(tool.getEndTimeOfDay(new Date())));
        System.out.println(tool.getTime(tool.offsiteDay(new Date(), -1)));
        System.out.println(tool.getTime(tool.offsiteWeek(new Date(), -1)));
        System.out.println(tool.getTime(tool.offsiteMonth(new Date(), -1)));
    }
}
