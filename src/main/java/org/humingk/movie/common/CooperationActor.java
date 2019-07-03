package org.humingk.movie.common;

import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;

import java.util.Map;
import java.util.Set;

/**
 * 演员合作电影类
 *
 * @author J1anbo
 * @author humingk
 */
public class CooperationActor {
    private Map<Integer, Actor> actorMap;
    private Map<Integer, Movie> movieMap;
    private Map<Integer, Set<Integer>> actorMovieMap;
    private int actorCount;
    private int movieCount;

    public Map<Integer, Actor> getActorMap() {
        return actorMap;
    }

    public void setActorMap(Map<Integer, Actor> actorMap) {
        this.actorMap = actorMap;
    }

    public Map<Integer, Movie> getMovieMap() {
        return movieMap;
    }

    public void setMovieMap(Map<Integer, Movie> movieMap) {
        this.movieMap = movieMap;
    }

    public int getActorCount() {
        return actorCount;
    }

    public void setActorCount(int actorCount) {
        this.actorCount = actorCount;
    }

    public int getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    public Map<Integer, Set<Integer>> getActorMovieMap() {
        return actorMovieMap;
    }

    public void setActorMovieMap(Map<Integer, Set<Integer>> actorMovieMap) {
        this.actorMovieMap = actorMovieMap;
    }
}
