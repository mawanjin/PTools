package com.php25.tools;

import com.php25.tools.FileUtils;
import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class FileUtilsTest {
    public final static String path = "C:\\Users\\jack\\Desktop\\1.txt";

    @Test
    public void readFile() {
        String temp = FileUtils.readFile(path, "utf-8").toString();
        System.out.println(temp);
    }

    @Test
    public void writeFile() {
        FileUtils.writeFile(path,"好的");
    }

    @Test
    public void writeFileAppend() {
        FileUtils.writeFile(path,"你好啊",true);
    }


}
