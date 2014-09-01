package com.php25.tools;

import com.php25.tools.factory.PToolsFactory;
import com.php25.tools.impl.StringToolImpl;
import org.junit.Test;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-7
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class StringToolTest {
    private static StringTool tool = PToolsFactory.getInstance().getStringTool();

    @Test
    public void isEmpty(){
        System.out.println(tool.isEmpty(""));
        System.out.println(tool.isEmpty(null));
        System.out.println(tool.isEmpty(" "));
    }

    @Test
    public void isBlank() {
        System.out.println(tool.isBlank(""));
        System.out.println(tool.isBlank(null));
        System.out.println(tool.isBlank(" "));
    }

    @Test
    public void isEqual() {
        String a = new String("hello");
        String b = "hello";
        System.out.println(tool.isEquals(a, b));
    }

    @Test
    public void nullStrToEmpty() {
        System.out.println(tool.nullStrToEmpty(null));
    }

    @Test
    public void capitalizeFirstLetter() {
        System.out.println(tool.capitalizeFirstLetter("abc"));
    }

    @Test
    public void utf8Encode() {
        System.out.println(tool.utf8Encode("好的就这样子"));
    }

}
