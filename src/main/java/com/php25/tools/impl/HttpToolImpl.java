package com.php25.tools.impl;

import com.php25.tools.HttpTool;
import com.php25.tools.StringTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
public class HttpToolImpl implements HttpTool {
    private StringTool stringTool;

    public HttpToolImpl(StringTool stringTool) {
        this.stringTool = stringTool;
    }

    @Override
    public String get(String url, Map<String, String> params) {
        if (stringTool.isBlank(url)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        HttpURLConnection conn = null;
        BufferedReader in = null;
        try {
            URL u = new URL(url + "?" + getStringParams(params));
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

    @Override
    public String post(String url, Map<String, String> params) {
        if (stringTool.isBlank(url)) {
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

            out = new PrintWriter(conn.getOutputStream());
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
                if (null != in) {
                    in.close();
                    in = null;
                }

                if (null != out) {
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


    @Override
    public String getStringParams(Map<String, String> params) {
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
