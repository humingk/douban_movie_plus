package org.humingk.movie.common.movieResource.resource;

import java.util.List;

/**
 * @author humingk
 */
public class BtbtdyResource {
    private String movieName;
    private String movieUrl;
    /**
     * 720p下载地址
     */
    private List<Resource> p720;
    public static final String P720_TYPE = "720p下载地址";
    /**
     * 1080p下载地址
     */
    private List<Resource> p1080;
    public static final String P1080_TYPE = "1080p下载地址";
    /**
     * 4k下载地址
     */
    private List<Resource> k4;
    public static final String K4_TYPE = "4k下载地址";
    /**
     * ED2K下载地址
     */
    private List<Resource> ed2k;
    public static final String ED2K_TYPE = "ED2K下载地址";
    /**
     * 蓝光原盘下载地址
     */
    private List<Resource> blue;
    public static final String BLUE_TYPE = "蓝光原盘下载地址";

    private List<Resource> unknown;
    /**
     * 未知下载地址
     */
    public static final String UNKNOWN_TYPE = "未知";

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<Resource> getP720() {
        return p720;
    }

    public void setP720(List<Resource> p720) {
        this.p720 = p720;
    }

    public List<Resource> getP1080() {
        return p1080;
    }

    public void setP1080(List<Resource> p1080) {
        this.p1080 = p1080;
    }

    public List<Resource> getK4() {
        return k4;
    }

    public void setK4(List<Resource> k4) {
        this.k4 = k4;
    }

    public List<Resource> getBlue() {
        return blue;
    }

    public void setBlue(List<Resource> blue) {
        this.blue = blue;
    }

    public List<Resource> getUnknown() {
        return unknown;
    }

    public void setUnknown(List<Resource> unknown) {
        this.unknown = unknown;
    }

    public List<Resource> getEd2k() {
        return ed2k;
    }

    public void setEd2k(List<Resource> ed2k) {
        this.ed2k = ed2k;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }
}
