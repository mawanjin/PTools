package com.php25.tools;

import com.php25.tools.impl.RegexElement;

import java.util.List;

/**
 * Created by jack on 2014/9/1.
 */
public interface RegexTool {

    /**
     * 根据正则表达式，找到匹配的内容
     *
     * @param content 需匹配的内容
     * @param regex   正则表达式
     * @param mode    Pattern.CASE_INSENSITIVE等
     * @return List<RegexElement> 如果没有找到list.size=0
     */
    public List<RegexElement> find(String content, String regex, int mode);

    /**
     * 根据正则表达式，找到匹配的内容
     *
     * @param content
     * @param regex
     * @return List<RegexElement> 如果没有找到list.size=0
     */
    public List<RegexElement> find(String content, String regex);
}
