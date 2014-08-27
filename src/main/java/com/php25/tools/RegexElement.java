package com.php25.tools;

import java.util.List;

public class RegexElement {
    private Integer start;
    private Integer end;
    private List<String> matchedContent;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public List<String> getMatchedContent() {
        return matchedContent;
    }

    public void setMatchedContent(List<String> matchedContent) {
        this.matchedContent = matchedContent;
    }

    @Override
    public String toString() {
        return "RegexElement{" +
                "start=" + start +
                ", end=" + end +
                ", matchedContent=" + matchedContent +
                '}';
    }
}