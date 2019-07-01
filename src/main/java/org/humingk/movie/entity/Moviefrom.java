package org.humingk.movie.entity;

public class Moviefrom {
    private Integer moviefromId;

    private String moviefromName;

    private String moviefromUrl;

    public Integer getMoviefromId() {
        return moviefromId;
    }

    public void setMoviefromId(Integer moviefromId) {
        this.moviefromId = moviefromId;
    }

    public String getMoviefromName() {
        return moviefromName;
    }

    public void setMoviefromName(String moviefromName) {
        this.moviefromName = moviefromName == null ? null : moviefromName.trim();
    }

    public String getMoviefromUrl() {
        return moviefromUrl;
    }

    public void setMoviefromUrl(String moviefromUrl) {
        this.moviefromUrl = moviefromUrl == null ? null : moviefromUrl.trim();
    }
}