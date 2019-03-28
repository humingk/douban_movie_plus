package org.humingk.movie.mapper;

import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;

import java.util.List;

public interface ActorMapper {
    int deleteByPrimaryKey(Integer actorId);

    int insert(Actor record);

    Actor selectByPrimaryKey(Integer actorId);

    List<Actor> selectAll();

    int updateByPrimaryKey(Actor record);

    // 根据演员ID查找所有的电影list

    List<Movie> selectMoviesByDirectorId(Integer directorId);

    List<Movie> selectMoviesByWriterId(Integer writerId);

    List<Movie> selectMoviesByLeadingactorId(Integer leadingactorId);
}