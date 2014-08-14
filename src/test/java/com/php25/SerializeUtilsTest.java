package com.php25;

import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class SerializeUtilsTest {
    public final static String path = "C:\\Users\\jack\\Desktop\\2.txt";
    @Test
    public void serialization() {
        SerializeUtils.serialization(path,new String("asdf"));
    }

    @Test
    public void deserialization(){
        String value = (String)SerializeUtils.deserialization(path);
        System.out.println(value);
    }
}
