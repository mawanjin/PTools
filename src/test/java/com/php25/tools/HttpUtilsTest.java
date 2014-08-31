package com.php25.tools;

import com.sun.deploy.net.HttpResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2014/8/30.
 */
public class HttpUtilsTest {

    @Test
    public void get() throws Exception{
        HttpUtils.get("http://7.su.bdimg.com/icon/10062.png",null);
        HttpUtils.get("http://7.su.bdimg.com/icon/10062.png",null);
    }

    @Test
    public void getStringParams() {
        Map<String,String> params = new HashMap<>();
        params.put("a","123");
        params.put("b","321");
        System.out.println(HttpUtils.getStringParams(params));
    }
}
