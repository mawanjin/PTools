package com.php25.tools;

import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class FileToolTest {
    public final static String path = "/Users/jack/Desktop/cache/1.txt";

    @Test
    public void readFile() {
        String temp = FileTool.readFile(path, "utf-8").toString();
        System.out.println(temp);
    }

    @Test
    public void writeFile() {
        FileTool.writeFile(path, "好的");
    }

    @Test
    public void writeFileAppend() {
        FileTool.writeFile(path, "你好啊", true);
    }


}
