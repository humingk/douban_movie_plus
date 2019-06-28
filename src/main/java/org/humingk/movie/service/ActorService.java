package org.humingk.movie.service;

import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;

import java.util.List;

/**
 * @author humin
 */
public interface ActorService {
    Actor getActorByActorId(int actorId);

    /**
     * 根据演员id获取所有的电影
     * @param actorId
     * @return
     */
    List<Movie> getMoviesByDirectorId(int actorId);

    List<Movie> getMoviesByWriterId(int actorId);

    List<Movie> getMoviesByLeadingactorId(int actorId);

    List<List<Movie>> getAllMoviesByActorId(int actorId);

    List<CooperationActor> getCoomovieByActorId(int actorId);
}
