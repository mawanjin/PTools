package com.php25.tools;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by jack on 2014/8/14.
 */
public class RandomToolTest {

    @Test
    public void getRandomNumbersAndLetters() {
        String result = RandomTool.getRandomNumbersAndLetters(10);
        System.out.println(result);
    }

    @Test
    public void  getRandomNumbers(){
        String result = RandomTool.getRandomNumbers(5);
        System.out.println(result);
    }

    @Test
    public void getRandomLetters() {
        String result = RandomTool.getRandomLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandomCapitalLetters(){
        String result = RandomTool.getRandomCapitalLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandomLowerCaseLetters(){
        String result = RandomTool.getRandomLowerCaseLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandom(){
        String result = RandomTool.getRandom("ad3aadffccaa", 5);
        System.out.println(result);
    }

    @Test
    public void getRandomNum(){
        int a = RandomTool.getRandom(100);
        int b = RandomTool.getRandom(50, 100);
        System.out.println(a + ":" + b);
    }

    @Test
    public void shuffle(){
        int[] arr = RandomTool.shuffle(new int[]{1, 2, 3, 5});
        System.out.println(Arrays.toString(arr));

        String[] arr1 = new String[]{"1","2","3","5"};

        System.out.println(Arrays.toString(RandomTool.shuffle(arr1)));

        Integer[] arr2 = new Integer[]{1,2,3,5};

        System.out.println(Arrays.toString(RandomTool.shuffle(arr2)));
    }

    @Test
    public void randomUUID() {
        System.out.println(RandomTool.randomUUID());
    }
}
