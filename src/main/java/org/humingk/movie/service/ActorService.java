package org.humingk.movie.service;

import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;

import java.util.List;

/**
 * @author humin
 */
public interface ActorService {
    Actor getActor(int actorId);

    /**
     * 根据演员id获取所有的电影
     * @param actorId
     * @return
     */
    List<Movie> getMoviesByDirectorId(int actorId);

    List<Movie> getMoviesByWriterId(int actorId);

    List<Movie> getMoviesByleadingactorId(int actorId);
}
