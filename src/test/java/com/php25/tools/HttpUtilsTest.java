package com.php25.tools;

import com.php25.caches.FileCache;
import com.sun.deploy.net.HttpResponse;
import org.junit.Test;

import java.net.ResponseCache;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2014/8/30.
 */
public class HttpUtilsTest {

    @Test
    public void get() throws Exception{
        ResponseCache.setDefault(new FileCache(10 * 1024 * 1024L, "/Users/jack/Desktop/cache"));

//        HttpUtils.get("http://7.su.bdimg.com/icon/10062.png",null);
//        HttpUtils.get("http://www.sina.com.cn",null);
//        HttpUtils.get("http://www.baidu.com",null);
        System.out.println(HttpUtils.get("http://programmer.csdn.net/",null));

    }

    @Test
    public void post() throws Exception {
        ResponseCache.setDefault(new FileCache(10 * 1024 * 1024L, "/Users/jack/Desktop/cache"));
        HttpUtils.post("http://7.su.bdimg.com/icon/10062.png",null);
       //HttpUtils.post("http://www.sina.com.cn",null);
       // HttpUtils.post("http://www.baidu.com",null);
    }

    @Test
    public void getStringParams() {
        Map<String,String> params = new HashMap<>();
        params.put("a","123");
        params.put("b","321");
        System.out.println(HttpUtils.getStringParams(params));
    }
}
