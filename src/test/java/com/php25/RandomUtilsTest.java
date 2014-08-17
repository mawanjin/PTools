package com.php25;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by jack on 2014/8/14.
 */
public class RandomUtilsTest {

    @Test
    public void getRandomNumbersAndLetters() {
        String result = RandomUtils.getRandomNumbersAndLetters(10);
        System.out.println(result);
    }

    @Test
    public void  getRandomNumbers(){
        String result = RandomUtils.getRandomNumbers(5);
        System.out.println(result);
    }

    @Test
    public void getRandomLetters() {
        String result = RandomUtils.getRandomLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandomCapitalLetters(){
        String result = RandomUtils.getRandomCapitalLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandomLowerCaseLetters(){
        String result = RandomUtils.getRandomLowerCaseLetters(5);
        System.out.println(result);
    }

    @Test
    public void getRandom(){
        String result = RandomUtils.getRandom("ad3aadffccaa",5);
        System.out.println(result);
    }

    @Test
    public void getRandomNum(){
        int a = RandomUtils.getRandom(100);
        int b = RandomUtils.getRandom(50,100);
        System.out.println(a + ":" + b);
    }

    @Test
    public void shuffle(){
        int[] arr = RandomUtils.shuffle(new int[]{1, 2, 3, 5});
        System.out.println(Arrays.toString(arr));

        String[] arr1 = new String[]{"1","2","3","5"};

        System.out.println(Arrays.toString(RandomUtils.shuffle(arr1)));

        Integer[] arr2 = new Integer[]{1,2,3,5};

        System.out.println(Arrays.toString(RandomUtils.shuffle(arr2)));
    }

    @Test
    public void randomUUID() {
        System.out.println(RandomUtils.randomUUID());
    }
}
