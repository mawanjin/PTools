package com.php25.tools;

import com.php25.tools.factory.PToolsFactory;
import com.php25.tools.impl.FileToolImpl;
import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class FileToolTest {
    public final static String path = "C:\\Users\\jack\\Desktop\\1.txt";
    private static FileTool tool = PToolsFactory.getInstance().getFileTool();

    @Test
    public void readFile() {
        String temp = tool.readFile(path, "utf-8").toString();
        System.out.println(temp);
    }

    @Test
    public void writeFile() {
        tool.writeFile(path, "好的");
    }

    @Test
    public void writeFileAppend() {
        tool.writeFile(path, "你好啊", true);
    }


}
