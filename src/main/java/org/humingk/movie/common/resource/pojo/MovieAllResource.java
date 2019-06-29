package org.humingk.movie.common.resource.pojo;

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
    private List<MovieMap> movieMapList;

    private BtbtdyResource btbtdyResource;

    private DygodResource dygodResource;

    private LoldyttResource loldyttResource;

    private Xl720Resource xl720Resource;

    public String getMovieKeywords() {
        return movieKeywords;
    }

    public void setMovieKeywords(String movieKeywords) {
        this.movieKeywords = movieKeywords;
    }

    public BtbtdyResource getBtbtdyResource() {
        return btbtdyResource;
    }

    public void setBtbtdyResource(BtbtdyResource btbtdyResource) {
        this.btbtdyResource = btbtdyResource;
    }

    public DygodResource getDygodResource() {
        return dygodResource;
    }

    public void setDygodResource(DygodResource dygodResource) {
        this.dygodResource = dygodResource;
    }

    public LoldyttResource getLoldyttResource() {
        return loldyttResource;
    }

    public void setLoldyttResource(LoldyttResource loldyttResource) {
        this.loldyttResource = loldyttResource;
    }

    public Xl720Resource getXl720Resource() {
        return xl720Resource;
    }

    public void setXl720Resource(Xl720Resource xl720Resource) {
        this.xl720Resource = xl720Resource;
    }

    public List<MovieMap> getMovieMapList() {
        return movieMapList;
    }

    public void setMovieMapList(List<MovieMap> movieMapList) {
        this.movieMapList = movieMapList;
    }
}
