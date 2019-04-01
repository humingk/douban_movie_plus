package org.humingk.movie.service.impl;

import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.mapper.ActorMapper;
import org.humingk.movie.mapper.MovieMapper;
import org.humingk.movie.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author humin
 */
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Actor getActor(int actorId) {
        try{
            Actor actor=actorMapper.selectByPrimaryKey(actorId);
            return actor;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByDirectorId(int actorId) {
        try{
            List<Movie> movies =movieMapper.selectMoviesByDirectorId(actorId);
            return movies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByWriterId(int actorId) {
        try{
            List<Movie> movies =movieMapper.selectMoviesByWriterId(actorId);
            return movies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getMoviesByleadingactorId(int actorId) {
        try{
            List<Movie> movies =movieMapper.selectMoviesByLeadingactorId(actorId);
            return movies;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
