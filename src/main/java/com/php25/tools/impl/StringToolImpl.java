package com.php25.tools.impl;

import com.php25.tools.StringTool;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class StringToolImpl implements StringTool {

    public boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }


    public boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }


    public boolean isEquals(String actual, String expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }


    public String nullStrToEmpty(String str) {
        return (str == null ? "" : str);
    }


    public String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }

        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str : new StringBuilder(str.length())
                .append(Character.toUpperCase(c)).append(str.substring(1)).toString();
    }

    public String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    public String utf8Encode(String str, String defaultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defaultReturn;
            }
        }
        return str;
    }


}
