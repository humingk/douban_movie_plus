package org.humingk.movie.entity;

public class UserMovie {
    private Integer userId;

    private Integer movieId;

    private Float rate;

    private Boolean wish;

    private Boolean sean;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Boolean getWish() {
        return wish;
    }

    public void setWish(Boolean wish) {
        this.wish = wish;
    }

    public Boolean getSean() {
        return sean;
    }

    public void setSean(Boolean sean) {
        this.sean = sean;
    }
}