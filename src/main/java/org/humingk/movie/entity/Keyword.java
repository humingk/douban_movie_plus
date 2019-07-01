package org.humingk.movie.entity;

public class Keyword {
    private String keywordContent;

    private Integer moviemapFlag;

    private Integer resourcelistFlag;

    public String getKeywordContent() {
        return keywordContent;
    }

    public void setKeywordContent(String keywordContent) {
        this.keywordContent = keywordContent == null ? null : keywordContent.trim();
    }

    public Integer getMoviemapFlag() {
        return moviemapFlag;
    }

    public void setMoviemapFlag(Integer moviemapFlag) {
        this.moviemapFlag = moviemapFlag;
    }

    public Integer getResourcelistFlag() {
        return resourcelistFlag;
    }

    public void setResourcelistFlag(Integer resourcelistFlag) {
        this.resourcelistFlag = resourcelistFlag;
    }
}