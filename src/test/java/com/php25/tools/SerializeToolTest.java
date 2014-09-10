package com.php25.tools;

import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class SerializeToolTest {
    public final static String path = "/Users/jack/Desktop/cache/2.txt";
    @Test
    public void serialization() {
        SerializeTool.serialization(path, new String("asdf"));
    }

    @Test
    public void deserialization(){
        String value = (String) SerializeTool.deserialization(path);
        System.out.println(value);
    }
}
