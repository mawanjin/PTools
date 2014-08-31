package com.php25.tools;

import com.php25.caches.FileCache;
import com.php25.caches.MemoryCache;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ResponseCache;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-30
 * Time: 下午12:52
 * To change this template use File | Settings | File Templates.
 */
public class HttpUtils {
        static {
            ResponseCache.setDefault(new FileCache(10*1024*1024L,"C:/Users/jack/Desktop/cache"));
        }

        /**
         * 如果获取成功，返回response的内容；否则返回null或者""或者抛出RuntimeException
         *
         * @param url
         * @param params
         * @return
         */
        public static String get(String url, Map<String, String> params) {
            if (StringUtils.isBlank(url)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            HttpURLConnection conn = null;
            try {
                URL u = new URL(url + getStringParams(params));
                final String host = u.getHost();
                conn = (HttpURLConnection) u.openConnection();
                conn.setDoInput(true);
                conn.setDoOutput(false);
                conn.setUseCaches(true);
                conn.setConnectTimeout(30000);
                conn.setReadTimeout(30000);
                //conn.setIfModifiedSince(new Date("Thu, 05 Jun 2014 11:40:13 GMT").getTime());
                conn.setRequestMethod("GET");
                int statusCode = conn.getResponseCode();
                switch (statusCode) {
                    case 200:
                        InputStreamReader in = new InputStreamReader(conn.getInputStream());
                        BufferedReader r = new BufferedReader(in);
                        String c;
                        while ((c = r.readLine()) != null) {
                            sb.append(c);
                        }
                        break;
                    default:
                        break;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            } finally {
                if (null != conn) {
                    conn.disconnect();
                    conn = null;
                }
            }
            return sb.toString();
        }


        public static String getStringParams(Map<String, String> params) {
            if(params == null) {
                return "";
            }
            StringBuilder temp = new StringBuilder();
            temp.append("?");
            for (String key : params.keySet()) {
                temp.append(key).append("=").append(params.get(key)).append("&");
            }
            String value = temp.substring(0,temp.length()-1);
            return value;
        }

}
