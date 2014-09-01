package com.php25.tools;

/**
 * Created by jack on 2014/9/1.
 */
public interface PageTool {

    /**
     * 将页数和每页条目数转换为开始位置和结束位置<br>
     * 此方法用于不包括结束位置的分页方法<br>
     * 例如：<br>
     * 页码：1，每页10 -> [0, 10]<br>
     * 页码：2，每页10 -> [10, 20]<br>
     * 。。。<br>
     *
     * @param pageNo       页码（从1计数）
     * @param countPerPage 每页条目数
     * @return 第一个数为开始位置，第二个数为结束位置
     */
    public int[] transToStartEnd(int pageNo, int countPerPage);

    /**
     * 根据总数计算总页数
     *
     * @param totalCount 总数
     * @param numPerPage 每页数
     * @return 总页数
     */
    public int totalPage(int totalCount, int numPerPage);
}
