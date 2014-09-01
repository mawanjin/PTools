package com.php25.tools.impl;

import com.php25.tools.PageTool;

public class PageToolImpl implements PageTool {

    @Override
    public int[] transToStartEnd(int pageNo, int countPerPage) {
        if (pageNo < 1) {
            pageNo = 1;
        }

        if (countPerPage < 1) {
            countPerPage = 0;
        }

        int start = (pageNo - 1) * countPerPage;
        int end = start + countPerPage;

        return new int[]{start, end};
    }


    @Override
    public int totalPage(int totalCount, int numPerPage) {
        if (numPerPage == 0) {
            return 0;
        }
        return totalCount % numPerPage == 0 ? (totalCount / numPerPage) : (totalCount / numPerPage + 1);
    }
}
