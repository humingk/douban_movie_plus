package org.humingk.movie.service;

import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;

import java.util.List;

/**
 * @author humingk
 * @author J1anbo
 */
public interface ActorService {
    Actor getActorByActorId(int actorId);

    /**
     * 根据演员id获取所有的电影
     *
     * @param actorId
     * @return
     */
    List<Movie> getAllMoviesByActorId(int actorId);

    /**
     * 根据演员id获取所有的电影
     * @param actorId
     * @return
     */
    List<Movie> getMoviesByDirectorId(int actorId);

    List<Movie> getMoviesByWriterId(int actorId);

    List<Movie> getMoviesByLeadingactorId(int actorId);

    /**
     * 返回某演员合作过的演员及其相关电影
     *
     * @param actorId
     * @param max     合作次数最大值
     * @return
     */
    CooperationActor getCoperationActor(int actorId, int max);
}
