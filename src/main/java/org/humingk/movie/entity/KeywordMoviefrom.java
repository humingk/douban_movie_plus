package org.humingk.movie.entity;

public class KeywordMoviefrom {
    private String keywordContent;

    private String moviefromUrl;

    public String getKeywordContent() {
        return keywordContent;
    }

    public void setKeywordContent(String keywordContent) {
        this.keywordContent = keywordContent == null ? null : keywordContent.trim();
    }

    public String getMoviefromUrl() {
        return moviefromUrl;
    }

    public void setMoviefromUrl(String moviefromUrl) {
        this.moviefromUrl = moviefromUrl == null ? null : moviefromUrl.trim();
    }
}