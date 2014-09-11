package com.php25.tools;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
    public void copyFile() {
        FileTool.copyFile("C:\\Users\\jack\\Desktop\\cache\\index","C:\\Users\\jack\\Desktop\\cache\\index1");
    }

    @Test
    public void writeFile() {
        FileTool.writeFile(path, "好的");
    }

    @Test
    public void writeFileAppend() {
        FileTool.writeFile(path, "你好啊", true);
    }

    @Test
    public void test() {
        String indexPath = "C:/Users/jack/Desktop/cache/index";

        File file = new File(indexPath);
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            if(file.exists()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                Map<String,String> value =  (Map<String,String>)inputStream.readObject();
                value.put("aaa","12311");
                System.out.println(value.toString());
                inputStream.close();
                outputStream = new ObjectOutputStream(new FileOutputStream(file));
                outputStream.writeObject(value);
                outputStream.close();
            }else {
                outputStream = new ObjectOutputStream(new FileOutputStream(file));
                Map<String,String> map = new HashMap<>();
                map.put("agc","123");
                outputStream.writeObject(map);
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != inputStream) {
                    inputStream.close();
                    inputStream = null;
                }

                if(null != outputStream) {
                    outputStream.close();
                    outputStream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
