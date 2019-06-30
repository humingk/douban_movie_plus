package org.humingk.movie.common.resource.pojo;

/**
 * @author humingk
 */
public class ClientResource<T extends ClientResource> {
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
