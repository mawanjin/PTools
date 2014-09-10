package com.php25.tools;

import org.junit.Test;

import java.util.List;

/**
 * Created with penghuiping
 * User: penghuiping
 * Date: 14-8-27
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class RegexToolTest {

    @Test
    public void find() {
        String content = "123.8991ASDFLLLBAD8891.222";
        String regex = "([0-9]+).([0-9]+)";
        List<RegexElement> regexElements = RegexTool.find(content, regex);
        for(RegexElement e:regexElements) {
            System.out.println(e);
        }
    }
}
