package org.humingk.movie.common.resource.pojo;

/**
 * @author humingk
 */
public class Movie {
    private String movieName;
    private String movieUrl;

    public Movie() {
    }

    public Movie(String movieName, String movieUrl) {
        this.movieName = movieName;
        this.movieUrl = movieUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }
}
