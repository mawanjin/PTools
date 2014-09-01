package com.php25.tools;

import java.util.Map;

/**
 * Created by jack on 2014/9/1.
 */
public interface HttpTool {
    /**
     * 如果获取成功，返回response的内容；否则返回null或者""或者抛出RuntimeException
     *
     * @param url
     * @param params
     * @return
     */
    public String get(String url, Map<String, String> params);

    /**
     * 如果获取成功，返回response的内容；否则返回null或者""或者抛出RuntimeException
     *
     * @param url
     * @param params
     * @return
     */
    public String post(String url, Map<String, String> params);

    /**
     * 把Map<String,String>参数，拼接成"name=123&password=pwd"这种形式
     * 如果 params为null 则返回""
     *
     * @param params
     * @return
     */
    public String getStringParams(Map<String, String> params);
}
