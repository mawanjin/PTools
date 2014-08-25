package com.php25.tools;

import com.php25.tools.DigestUtils;
import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class DigestUtilsTest {

    @Test
    public void md5()
    {
       System.out.println(DigestUtils.md5("asdf"));
    }
}
