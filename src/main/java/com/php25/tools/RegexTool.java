package com.php25.tools;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-27
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
public class RegexTool {

    /**
     * 根据正则表达式，找到匹配的内容
     * @param content  需匹配的内容
     * @param regex  正则表达式
     * @param mode  Pattern.CASE_INSENSITIVE等
     * @return  List<RegexElement> 如果没有找到list.size=0
     */
    public static List<RegexElement> find(String content,String regex,int mode) {
        Pattern p = Pattern.compile(regex,mode);
        Matcher m = p.matcher(content);
        List<RegexElement> regexElements = new ArrayList<RegexElement>();
        while(m.find()) {
            RegexElement regexElement = new RegexElement();
            regexElement.setStart(m.start());
            regexElement.setEnd(m.end());
            List<String> matchedContent = new ArrayList<String>();
            for(int i=0;i<=m.groupCount();i++) {
                matchedContent.add(m.group(i));
            }
            regexElement.setMatchedContent(matchedContent);
            regexElements.add(regexElement);
        }
        return regexElements;
    }

    /**
     * 根据正则表达式，找到匹配的内容
     * @param content
     * @param regex
     * @return  List<RegexElement> 如果没有找到list.size=0
     */
    public static List<RegexElement> find(String content,String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        List<RegexElement> regexElements = new ArrayList<RegexElement>();
        while(m.find()) {
            RegexElement regexElement = new RegexElement();
            regexElement.setStart(m.start());
            regexElement.setEnd(m.end());
            List<String> matchedContent = new ArrayList<String>();
            for(int i=0;i<=m.groupCount();i++) {
                matchedContent.add(m.group(i));
            }
            regexElement.setMatchedContent(matchedContent);
            regexElements.add(regexElement);
        }
        return regexElements;
    }


}


