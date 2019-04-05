package org.humingk.movie.common;

/**
 * WishAndSeenAndRate
 *
 */
public class UserWish {

    private int userId;
    private int movieId;
    private String label;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}