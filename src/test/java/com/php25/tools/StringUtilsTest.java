package com.php25.tools;

import com.php25.tools.StringUtils;
import org.junit.Test;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-7
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class StringUtilsTest {


    @Test
    public void isEmpty(){
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(" "));
    }

    @Test
    public void isBlank() {
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(" "));
    }

    @Test
    public void isEqual() {
        String a = new String("hello");
        String b = "hello";
        System.out.println(StringUtils.isEquals(a,b));
    }

    @Test
    public void nullStrToEmpty() {
        System.out.println(StringUtils.nullStrToEmpty(null));
    }

    @Test
    public void capitalizeFirstLetter() {
        System.out.println(StringUtils.capitalizeFirstLetter("abc"));
    }

    @Test
    public void utf8Encode() {
        System.out.println(StringUtils.utf8Encode("好的就这样子"));
    }

}
