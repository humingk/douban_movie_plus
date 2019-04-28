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
    private List<Resource> magnet;
    private List<Resource> thunder;

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


    public List<Resource> getThunder() {
        return thunder;
    }

    public void setThunder(List<Resource> thunder) {
        this.thunder = thunder;
    }

    public List<Resource> getMagnet() {
        return magnet;
    }

    public void setMagnet(List<Resource> magnet) {
        this.magnet = magnet;
    }
}
