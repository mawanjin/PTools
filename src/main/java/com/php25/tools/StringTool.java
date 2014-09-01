package com.php25.tools;

/**
 * Created by jack on 2014/9/1.
 */
public interface StringTool {

    /**
     * 如果字符串为null或者""或者"  "都返回true
     *
     * @param str
     * @return
     */
    public boolean isBlank(String str);

    /**
     * 如果字符串为null或者""返回true
     *
     * @param str
     * @return
     */
    public boolean isEmpty(String str);

    /**
     * 判断两个字符串时候相等
     *
     * @param actual
     * @param expected
     * @return
     */
    public boolean isEquals(String actual, String expected);

    /**
     * 把null转换成空字符串
     *
     * @param str
     * @return 如果参数str不是null，则直接返回str
     */
    public String nullStrToEmpty(String str);

    /**
     * 使得字符串的首字母大写
     * <p>
     * <pre>
     * capitalizeFirstLetter(null)     =   null;
     * capitalizeFirstLetter("")       =   "";
     * capitalizeFirstLetter("2ab")    =   "2ab"
     * capitalizeFirstLetter("a")      =   "A"
     * capitalizeFirstLetter("ab")     =   "Ab"
     * capitalizeFirstLetter("Abc")    =   "Abc"
     * </pre>
     *
     * @param str
     * @return
     */
    public String capitalizeFirstLetter(String str);

    /**
     * URLEncode中文字符串，编码是utf-8
     * <p>
     * <pre>
     * utf8Encode(null)        =   null
     * utf8Encode("")          =   "";
     * utf8Encode("aa")        =   "aa";
     * utf8Encode("啊啊啊啊")   = "%E5%95%8A%E5%95%8A%E5%95%8A%E5%95%8A";
     * </pre>
     *
     * @param str
     * @return
     * @throws java.io.UnsupportedEncodingException if an error occurs
     */
    public String utf8Encode(String str);

    /**
     * URLEncode中文字符串,编码是utf-8，如果出错了，返回defaultReturn
     *
     * @param str
     * @param defaultReturn
     * @return
     */
    public String utf8Encode(String str, String defaultReturn);
}
