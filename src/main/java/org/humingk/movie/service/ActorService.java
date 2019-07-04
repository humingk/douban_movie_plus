package org.humingk.movie.service;

import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.entity.Actor;

import java.util.List;

/**
 * @author humingk
 * @author J1anbo
 */
public interface ActorService {
    Actor getActorByActorId(int actorId);


    /**
     * 返回某演员合作过的演员及其相关电影
     *
     * @param actorId
     * @param cooperationMin     合作次数最小值
     * @return
     */
    CooperationActor getCoperationActor(int actorId, int cooperationMin);

    /**
     * 根据movieId获取所有的演员
     *
     * @param movieId
     * @return
     */
    List<Actor> getAllActorsByMovieId(int movieId);

    List<Actor> getDirectorsByMovieId(int movieId);

    List<Actor> getWritersByMovieId(int movieId);

    List<Actor> getLeadingactorsByMovieId(int movieId);
}
