package com.php25.tools;

import com.php25.tools.factory.PToolsFactory;
import com.php25.tools.impl.SerializeToolImpl;
import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class SerializeToolTest {
    public final static String path = "C:\\Users\\jack\\Desktop\\2.txt";

    private static SerializeTool tool = PToolsFactory.getInstance().getSerializeTool();

    @Test
    public void serialization() {
        tool.serialization(path, new String("asdf"));
    }

    @Test
    public void deserialization(){
        String value = (String) tool.deserialization(path);
        System.out.println(value);
    }
}
