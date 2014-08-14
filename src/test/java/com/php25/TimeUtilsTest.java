package com.php25;

import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class TimeUtilsTest {
    @Test
    public void test() {
        System.out.println(TimeUtils.getCurrentTimeInString());
        System.out.println(TimeUtils.getCurrentTimeInLong());
    }
}
