package com.php25.tools;

import com.php25.tools.factory.PToolsFactory;
import com.php25.tools.impl.RandomToolImpl;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by jack on 2014/8/14.
 */
public class RandomToolTest {

    private static RandomTool tool = PToolsFactory.getInstance().getRandomTool();

    @Test
    public void getRandomNumbersAndLetters() {
        String result = tool.getRandomNumbersAndLetters(10);
        System.out.println(result);
    }

    @Test
    public void  getRandomNumbers(){
        String result = tool.getRandomNumbers(5);
        System.out.println(result);
    }

    @Test
    public void getRandomLetters() {
        String result = tool.getRandomLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandomCapitalLetters(){
        String result = tool.getRandomCapitalLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandomLowerCaseLetters(){
        String result = tool.getRandomLowerCaseLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandom(){
        String result = tool.getRandom("ad3aadffccaa", 5);
        System.out.println(result);
    }

    @Test
    public void getRandomNum(){
        int a = tool.getRandom(100);
        int b = tool.getRandom(50, 100);
        System.out.println(a + ":" + b);
    }

    @Test
    public void shuffle(){
        int[] arr = tool.shuffle(new int[]{1, 2, 3, 5});
        System.out.println(Arrays.toString(arr));

        String[] arr1 = new String[]{"1","2","3","5"};

        System.out.println(Arrays.toString(tool.shuffle(arr1)));

        Integer[] arr2 = new Integer[]{1,2,3,5};

        System.out.println(Arrays.toString(tool.shuffle(arr2)));
    }

    @Test
    public void randomUUID() {
        System.out.println(tool.randomUUID());
    }
}
