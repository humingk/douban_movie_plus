package org.humingk.movie.common;

import java.util.List;

/**
 * Loldytt电影资源类
 *
 * @author humin
 */
public class LoldyttResource {
    private String movieName;
    private String movieUrl;
    private List<Resource> resources;

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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
