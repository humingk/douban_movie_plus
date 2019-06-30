package org.humingk.movie.common.resource.pojo;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;

import java.util.List;

/**
 * 电影表
 *
 * @author humingk
 */
public class MovieMap<T extends AbstractMovieResourceAdapter> {
    /**
     * 搜索关键字
     */
    private String keyword;
    /**
     * client类型
     */
    private Class<T> clientType;
    /**
     * client对应电影列表
     */
    private List<Movie> movies;

    public MovieMap() {
    }

    public MovieMap(String keyword, Class<T> clientType) {
        this.keyword = keyword;
        this.clientType = clientType;
    }

    public MovieMap(String keyword, Class<T> clientType, List<Movie> movies) {
        this.keyword = keyword;
        this.clientType = clientType;
        this.movies = movies;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Class<T> getClientType() {
        return clientType;
    }

    public void setClientType(Class<T> clientType) {
        this.clientType = clientType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
