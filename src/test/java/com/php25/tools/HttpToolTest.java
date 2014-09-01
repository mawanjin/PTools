package com.php25.tools;

import com.php25.tools.factory.PToolsFactory;
import com.php25.tools.impl.HttpToolImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2014/8/30.
 */
public class HttpToolTest {

    private static HttpTool tool = PToolsFactory.getInstance().getHttpTool();

    @Test
    public void get() throws Exception {
         //tool.get("http://7.su.bdimg.com/icon/10062.png",null);
         //tool.get("http://www.sina.com.cn",null);
         System.out.println(tool.get("http://www.baidu.com",null));
         //tool.get("http://programmer.csdn.net/",null);

    }

    @Test
    public void post() throws Exception {
       // tool.post("http://7.su.bdimg.com/icon/10062.png",null);
        System.out.println(tool.post("http://www.baidu.com",null));
    }

    @Test
    public void getStringParams() {
        Map<String, String> params = new HashMap<>();
        params.put("a", "123");
        params.put("b", "321");
        System.out.println(tool.getStringParams(params));
    }
}
