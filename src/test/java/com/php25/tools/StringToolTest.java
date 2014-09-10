package com.php25.tools;

import org.junit.Test;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-7
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class StringToolTest {


    @Test
    public void isEmpty(){
        System.out.println(StringTool.isEmpty(""));
        System.out.println(StringTool.isEmpty(null));
        System.out.println(StringTool.isEmpty(" "));
    }

    @Test
    public void isBlank() {
        System.out.println(StringTool.isBlank(""));
        System.out.println(StringTool.isBlank(null));
        System.out.println(StringTool.isBlank(" "));
    }

    @Test
    public void isEqual() {
        String a = new String("hello");
        String b = "hello";
        System.out.println(StringTool.isEquals(a, b));
    }

    @Test
    public void nullStrToEmpty() {
        System.out.println(StringTool.nullStrToEmpty(null));
    }

    @Test
    public void capitalizeFirstLetter() {
        System.out.println(StringTool.capitalizeFirstLetter("abc"));
    }

    @Test
    public void utf8Encode() {
        System.out.println(StringTool.utf8Encode("好的就这样子"));
    }

}
