package org.humingk.movie.service.impl;

import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.mapper.ActorMapper;
import org.humingk.movie.service.ActorService;
import org.humingk.movie.service.MovieService;
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
    private MovieService movieService;

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


    /**
     * 返回某演员合作过的演员及其相关电影
     *
     * @param actorId
     * @param cooperationMin 合作次数最小值
     * @return
     */
    @Override
    public CooperationActor getCoperationActor(int actorId, int cooperationMin) {
        CooperationActor result = new CooperationActor();
        Map<Integer, Actor> actorTempMap = new HashMap<>();
        Map<Integer, Movie> movieMap = new HashMap<>();
        Map<Integer, Set<Integer>> actorMovieMap = new LinkedHashMap<>();
        try {
            // 该演员参演的所有电影
            List<Movie> movieList = movieService.getAllMoviesByActorId(actorId);
            for (Movie movie : movieList) {
                // 电影表
                movieMap.put(movie.getMovieId(), movie);
                List<Actor> actorList = getAllActorsByMovieId(movie.getMovieId());
                if (actorList != null) {
                    for (Actor actor : actorList) {
                        // 演员表
                        actorTempMap.put(actor.getActorId(), actor);
                        // 新建actor对应的set
                        actorMovieMap.computeIfAbsent(actor.getActorId(), k -> new LinkedHashSet<>());
                        // 演员电影表
                        actorMovieMap.get(actor.getActorId()).add(movie.getMovieId());
                    }
                }
            }
            // 根据合作次数降序排序演员
            List<Map.Entry<Integer, Set<Integer>>> sortList = new ArrayList<>(actorMovieMap.entrySet());
            Collections.sort(sortList, (o1, o2) -> o2.getValue().size() - o1.getValue().size());
            // cooperationMin
            actorMovieMap = new LinkedHashMap<>();
            Map<Integer, Actor> actorMap = new HashMap<>();
            for (int i = 0; i < sortList.size() && sortList.get(i).getValue().size() >= cooperationMin; i++) {
                actorMovieMap.put(sortList.get(i).getKey(), sortList.get(i).getValue());
                actorMap.put(sortList.get(i).getKey(), actorMap.get(sortList.get(i).getKey()));
            }
            result.setActorMap(actorMap);
            result.setMovieMap(movieMap);
            result.setActorMovieMap(actorMovieMap);
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 根据movieId获取所有的演员
     *
     * @param movieId
     * @return
     */
    @Override
    public List<Actor> getAllActorsByMovieId(int movieId) {
        List<Actor> result = new ArrayList<>();
        try {
            List<Actor> actorList = actorMapper.selectDirectorsByMovieId(movieId);
            if (actorList != null) {
                result.addAll(actorList);
            }
            actorList = actorMapper.selectWritersByMovieId(movieId);
            if (actorList != null) {
                result.addAll(actorList);
            }
            actorList = actorMapper.selectLeadingactorsByMovieId(movieId);
            if (actorList != null) {
                result.addAll(actorList);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    @Override
    public List<Actor> getDirectorsByMovieId(int movieId) {
        List<Actor> result = null;
        try {
            result = actorMapper.selectDirectorsByMovieId(movieId);
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    @Override
    public List<Actor> getWritersByMovieId(int movieId) {
        List<Actor> result = null;
        try {
            result = actorMapper.selectWritersByMovieId(movieId);
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    @Override
    public List<Actor> getLeadingactorsByMovieId(int movieId) {
        List<Actor> result = null;
        try {
            result = actorMapper.selectLeadingactorsByMovieId(movieId);
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }
}
