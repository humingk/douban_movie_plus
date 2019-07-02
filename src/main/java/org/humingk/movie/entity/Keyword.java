package org.humingk.movie.entity;

public class Keyword {
    private String keyword;

    private Integer searchFlag;

    private Integer resourceFlag;

    public Keyword() {
    }

    public Keyword(String keyword, int searchFlag, int resourceFlag) {
        this.keyword = keyword;
        this.searchFlag = searchFlag;
        this.resourceFlag = resourceFlag;
    }


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getSearchFlag() {
        return searchFlag;
    }

    public void setSearchFlag(Integer searchFlag) {
        this.searchFlag = searchFlag;
    }

    public Integer getResourceFlag() {
        return resourceFlag;
    }

    public void setResourceFlag(Integer resourceFlag) {
        this.resourceFlag = resourceFlag;
    }
}