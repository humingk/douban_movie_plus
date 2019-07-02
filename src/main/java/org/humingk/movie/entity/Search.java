package org.humingk.movie.entity;

public class Search {
    private String movieUrl;

    private String keyword;

    private String movieName;

    private Integer clientType;

    public Search() {
    }

    public Search(String keyword, String movieName, String movieUrl, int clientType) {
        this.keyword = keyword;
        this.movieName = movieName;
        this.movieUrl = movieUrl;
        this.clientType = clientType;
    }

    public String toString() {
        return getKeyword() + " - " + getClientType() + " - " + getMovieName() + " - " + getMovieUrl();
    }

    ;

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl == null ? null : movieUrl.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName == null ? null : movieName.trim();
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }
}