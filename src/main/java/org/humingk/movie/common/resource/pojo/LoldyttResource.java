package org.humingk.movie.common.resource.pojo;

import java.util.List;

/**
 * @author humingk
 */
public class LoldyttResource {
    private Movie movie;
    /**
     * 磁力链接
     */
    private List<Resource> magnet;
    /**
     * 迅雷链接
     */
    private List<Resource> thunder;

    public void setThunder(List<Resource> thunder) {
        this.thunder = thunder;
    }

    public List<Resource> getMagnet() {
        return magnet;
    }

    public void setMagnet(List<Resource> magnet) {
        this.magnet = magnet;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
