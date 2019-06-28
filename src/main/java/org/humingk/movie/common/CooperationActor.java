package org.humingk.movie.common;

import org.humingk.movie.entity.*;
import java.util.List;

/**
 * 演员合作电影类
 *
 * @author J1anbo
 * @see  humingk
 */
public class CooperationActor {
    private Actor actor;
    private List<Movie> movies;
    private int movieCount;

    public CooperationActor(){}

    public CooperationActor(Actor actor, List<Movie> movies){
        this.actor = actor;
        this.movies = movies;
    }

    public int getMovieCount() {
        return movies.size();
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

}
