package org.humingk.movie.common.resource.pojo;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;

import java.util.List;

/**
 * 与搜索关键字相关的电影资源
 *
 * @author humingk
 */
public class MovieAllResource {
    /**
     * 电影关键字
     */
    private String movieKeywords;
    /**
     * 电影表列表
     */
    private List<MovieMap<? extends AbstractMovieResourceAdapter>> movieMapList;

    /**
     * 电影表对应电影资源列表
     */
    private List<ClientResource<? extends ClientResource>> resourceList;


    public String getMovieKeywords() {
        return movieKeywords;
    }

    public void setMovieKeywords(String movieKeywords) {
        this.movieKeywords = movieKeywords;
    }

    public List<MovieMap<? extends AbstractMovieResourceAdapter>> getMovieMapList() {
        return movieMapList;
    }

    public void setMovieMapList(List<MovieMap<? extends AbstractMovieResourceAdapter>> movieMapList) {
        this.movieMapList = movieMapList;
    }

    public List<ClientResource<? extends ClientResource>> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<ClientResource<? extends ClientResource>> resourceList) {
        this.resourceList = resourceList;
    }
}
