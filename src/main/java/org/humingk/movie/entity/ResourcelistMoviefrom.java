package org.humingk.movie.entity;

public class ResourcelistMoviefrom {
    private Integer resourcelistId;

    private String moviefromUrl;

    public Integer getResourcelistId() {
        return resourcelistId;
    }

    public void setResourcelistId(Integer resourcelistId) {
        this.resourcelistId = resourcelistId;
    }

    public String getMoviefromUrl() {
        return moviefromUrl;
    }

    public void setMoviefromUrl(String moviefromUrl) {
        this.moviefromUrl = moviefromUrl == null ? null : moviefromUrl.trim();
    }
}