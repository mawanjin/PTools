package com.php25.tools;

/**
 * Created by jack on 2014/9/1.
 */
public interface RandomTool {
    /**
     * 随即获取给定长度的字符串，数字+字母形式+大小写敏感
     *
     * @param length
     * @return
     */
    public String getRandomNumbersAndLetters(int length);

    /**
     * 获取给定长度的随机数
     *
     * @param length
     * @return
     */
    public String getRandomNumbers(int length);

    /**
     * 获取给定长度的随即字符串，字母形式+大小写敏感
     *
     * @param length
     * @return
     */
    public String getRandomLetters(int length);

    /**
     * 获取给定长度的大写字符
     *
     * @param length
     * @return
     */
    public String getRandomCapitalLetters(int length);

    /**
     * 获取给定长度的小写字符
     *
     * @param length
     * @return
     */
    public String getRandomLowerCaseLetters(int length);

    /**
     * 给定字符串数据源，从中生产随机字符串
     *
     * @param source 字符串数据源
     * @param length 给定长度
     * @return 如果数据源为null或者""，返回null
     */
    public String getRandom(String source, int length);

    /**
     * 给定字符串数据源，从中生产随机字符串
     *
     * @param sourceChar
     * @param length
     * @return 如果数据源为null或者""，返回null
     */
    public String getRandom(char[] sourceChar, int length);

    /**
     * 随机返回0到max之间的数字
     *
     * @param max
     * @return 如果max小于0 则返回0
     */
    public int getRandom(int max);

    /**
     * 随机返回min与max之间的数字
     *
     * @param min
     * @param max
     * @return 如果min大于max返回0，如果min等于max返回min
     */
    public int getRandom(int min, int max);

    /**
     * 从obj[]数组中，随机获取大小不定的obj[]数组
     *
     * @param objArray 源数组
     * @return 长度不定的obj数组，里面的元素是源数组的元素
     */
    public Object[] shuffle(Object[] objArray);

    /**
     * 从object[]数组中，随机获取指定大小的object[]数组
     *
     * @param objArray     源数组
     * @param shuffleCount 指定生产的数组大小
     * @return 回object数组，大小为shuffleCount，里面的元素是源数组的元素.如果objArray是null或者shuffleCount大于objArray的长度返回null
     */
    public Object[] shuffle(Object[] objArray, int shuffleCount);

    /**
     * 从int[]数组中，随机获取大小不定的int[]数组
     *
     * @param intArray 源数组
     * @return 长度不定的int数组，里面的元素是源数组的元素
     */
    public int[] shuffle(int[] intArray);

    /**
     * 从int[]数组中，随机获取指定大小的int[]数组
     *
     * @param intArray     源数组
     * @param shuffleCount 指定生产的数组大小
     * @return 返回int数组，大小为shuffleCount，里面的元素是源数组的元素.如果intArray是null或者shuffleCount大于intArray的长度返回null
     */
    public int[] shuffle(int[] intArray, int shuffleCount);

    /**
     * 获取随机uuid
     *
     * @return
     */
    public String randomUUID();
}
