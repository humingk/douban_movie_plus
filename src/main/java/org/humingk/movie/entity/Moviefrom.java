package org.humingk.movie.entity;

public class Moviefrom {
    private String moviefromUrl;

    private String moviefromName;

    public String getMoviefromUrl() {
        return moviefromUrl;
    }

    public void setMoviefromUrl(String moviefromUrl) {
        this.moviefromUrl = moviefromUrl == null ? null : moviefromUrl.trim();
    }

    public String getMoviefromName() {
        return moviefromName;
    }

    public void setMoviefromName(String moviefromName) {
        this.moviefromName = moviefromName == null ? null : moviefromName.trim();
    }
}