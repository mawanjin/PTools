package com.php25.tools;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-30
 * Time: 下午12:52
 * To change this template use File | Settings | File Templates.
 */
public class HttpTool {
    /**
     * 如果获取成功，返回response的内容；否则返回null或者""或者抛出RuntimeException
     *
     * @param url
     * @param params
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        if (StringTool.isBlank(url)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        HttpURLConnection conn = null;
        BufferedReader in = null;
        try {
            URL u = new URL(url +"?"+getStringParams(params));
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
                    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String c;
                    while ((c = in.readLine()) != null) {
                        sb.append(c);
                    }
                    break;
                default:
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (null != in) {
                    in.close();
                    in = null;
                }

                if (null != conn) {
                    conn.disconnect();
                    conn = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return sb.toString();
    }

    /**
     * 如果获取成功，返回response的内容；否则返回null或者""或者抛出RuntimeException
     * @param url
     * @param params
     * @return
     */
    public static String post(String url,Map<String,String> params) {
        if (StringTool.isBlank(url)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        HttpURLConnection conn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            URL u = new URL(url);
            conn = (HttpURLConnection) u.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            //conn.setIfModifiedSince(new Date("Thu, 05 Jun 2014 11:40:13 GMT").getTime());
            conn.setRequestMethod("POST");

            out  = new PrintWriter(conn.getOutputStream());
            out.print(getStringParams(params));
            out.flush();

            int statusCode = conn.getResponseCode();
            switch (statusCode) {
                case 200:
                    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String c;
                    while ((c = in.readLine()) != null) {
                        sb.append(c);
                    }
                    break;
                default:
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if(null != in) {
                    in.close();
                    in = null;
                }

                if(null != out) {
                    out.close();
                    out = null;
                }

                if (null != conn) {
                    conn.disconnect();
                    conn = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return sb.toString();
    }


    /**
     * 把Map<String,String>参数，拼接成"name=123&password=pwd"这种形式
     * 如果 params为null 则返回""
     * @param params
     * @return
     */
    public static String getStringParams(Map<String, String> params) {
        if (params == null) {
            return "";
        }
        StringBuilder temp = new StringBuilder();
        for (String key : params.keySet()) {
            temp.append(key).append("=").append(params.get(key)).append("&");
        }
        String value = temp.substring(0, temp.length() - 1);
        return value;
    }

}
