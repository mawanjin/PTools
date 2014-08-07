package com.php25;

import org.junit.Test;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-7
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class StringUtilsTest {
    private static StringUtils stringUtils = new StringUtils();

    @Test
    public void isEmpty(){
         System.out.println(stringUtils.isEmpty(""));
    }
}
