package org.humingk.movie.entity;

public class Resourcelist {
    private Integer resourcelistId;

    private String keywordContent;

    public Integer getResourcelistId() {
        return resourcelistId;
    }

    public void setResourcelistId(Integer resourcelistId) {
        this.resourcelistId = resourcelistId;
    }

    public String getKeywordContent() {
        return keywordContent;
    }

    public void setKeywordContent(String keywordContent) {
        this.keywordContent = keywordContent == null ? null : keywordContent.trim();
    }
}