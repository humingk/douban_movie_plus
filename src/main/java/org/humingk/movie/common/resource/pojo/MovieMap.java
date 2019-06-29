package org.humingk.movie.common.resource.pojo;

import java.util.List;

/**
 * 电影表
 *
 * @author humingk
 */
public class MovieMap {
    /**
     * client类型
     */
    private String clientType;
    /**
     * client对应电影列表
     */
    private List<Movie> movies;

    public MovieMap() {
    }

    public MovieMap(String clientType) {
        this.clientType = clientType;
    }

    public MovieMap(String clientType, List<Movie> movies) {
        this.clientType = clientType;
        this.movies = movies;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
