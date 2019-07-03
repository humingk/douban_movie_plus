package org.humingk.movie.service.impl;

import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.mapper.ActorMapper;
import org.humingk.movie.mapper.MovieMapper;
import org.humingk.movie.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author humingk
 * @author J1anbo
 */
@Transactional
@Service
public class ActorServiceImpl implements ActorService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Actor getActorByActorId(int actorId) {
        try {
            Actor actor = actorMapper.selectByPrimaryKey(actorId);
            return actor;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByDirectorId(int actorId) {
        try {
            List<Movie> movies = movieMapper.selectMoviesByDirectorId(actorId);
            return movies;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByWriterId(int actorId) {
        try {
            List<Movie> movies = movieMapper.selectMoviesByWriterId(actorId);
            return movies;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByLeadingactorId(int actorId) {
        try {
            List<Movie> movies = movieMapper.selectMoviesByLeadingactorId(actorId);
            return movies;
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }


    /**
     * 根据演员id获取该演员所参与的所有电影
     *
     * @param actorId
     * @return
     */
    @Override
    public List<Movie> getAllMoviesByActorId(int actorId) {
        List<Movie> result = new ArrayList<>();
        try {
            List<Movie> movieList = getMoviesByDirectorId(actorId);
            if (movieList != null) {
                result.addAll(movieList);
            }
            movieList = getMoviesByWriterId(actorId);
            if (movieList != null) {
                result.addAll(movieList);
            }
            movieList = getMoviesByLeadingactorId(actorId);
            if (movieList != null) {
                result.addAll(movieList);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 返回某演员合作过的演员及其相关电影
     *
     * @param actorId
     * @param max     合作次数最大值
     * @return
     */
    @Override
    public CooperationActor getCoperationActor(int actorId, int max) {
        CooperationActor result = null;
        Map<Integer, Actor> actorMap = new LinkedHashMap<>();
        Map<Integer, Movie> movieMap = new LinkedHashMap<>();
        Map<Integer, Set<Integer>> actorMovieMap = new LinkedHashMap<>();
        try {
            // 该演员参演的所有电影
            List<Movie> movieList = getAllMoviesByActorId(actorId);
            for (Movie movie : movieList) {
                // 电影表
                movieMap.put(movie.getMovieId(), movie);
                List<Actor> actorList = actorMapper.selectDirectorsOfMovieById(movie.getMovieId());
                for (Actor actor : actorList) {
                    // 演员表
                    actorMap.put(actor.getActorId(), actor);
                    // 新建actor对应的set
                    if (actorMovieMap.get(actorId) == null) {
                        actorMovieMap.put(actor.getActorId(), new LinkedHashSet<>());
                    }
                    // 演员电影表
                    actorMovieMap.get(actor.getActorId()).add(movie.getMovieId());
                }
            }
            result.setActorMap(actorMap);
            result.setMovieMap(movieMap);
            result.setActorMovieMap(actorMovieMap);
            // 根据合作次数排序演员

        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }
}
