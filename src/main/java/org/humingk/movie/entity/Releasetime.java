package org.humingk.movie.entity;

public class Releasetime {
    private Integer releasetimeId;

    private String timeArea;

    public Integer getReleasetimeId() {
        return releasetimeId;
    }

    public void setReleasetimeId(Integer releasetimeId) {
        this.releasetimeId = releasetimeId;
    }

    public String getTimeArea() {
        return timeArea;
    }

    public void setTimeArea(String timeArea) {
        this.timeArea = timeArea == null ? null : timeArea.trim();
    }
}