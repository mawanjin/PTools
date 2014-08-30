package com.php25.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-30
 * Time: 下午12:52
 * To change this template use File | Settings | File Templates.
 */
public class HttpUtils {
        private static Map<String, String> cookies = new HashMap<String, String>();

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
                conn.setUseCaches(false);
                conn.setConnectTimeout(30000);
                conn.setReadTimeout(30000);
                //conn.setIfModifiedSince();
                conn.setRequestMethod("GET");
                final String cookie = cookies.get(host);
                if (cookie != null) conn.addRequestProperty("Cookie", cookie);

                final String setCookie = conn.getHeaderField("Set-Cookie");
                if (!StringUtils.isBlank(setCookie)) {
                    cookies.put(host, setCookie);
                }
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                // chain the InputStream to a Reader
                BufferedReader r = new BufferedReader(in);
                String c;
                while ((c = r.readLine()) != null) {
                    sb.append(c);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != conn) {
                    conn.disconnect();
                    conn = null;
                }
            }

            return sb.toString();
        }

        private static String getStringParams(Map<String, String> params) {
            StringBuilder temp = new StringBuilder();
            temp.append("?");
            for (String key : params.keySet()) {
                temp.append(key).append("=").append(params.get(key)).append("&");
            }
            temp.substring(0, temp.length() - 1);
            return temp.toString();
        }

}
