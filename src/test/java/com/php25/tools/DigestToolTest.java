package com.php25.tools;

import com.php25.tools.factory.PToolsFactory;
import com.php25.tools.impl.DigestToolImpl;
import org.junit.Test;

/**
 * Created by jack on 2014/8/14.
 */
public class DigestToolTest {
    private static DigestTool tool = PToolsFactory.getInstance().getDigestTool();

    @Test
    public void md5()
    {
       System.out.println(tool.md5("asdf"));
    }
}
