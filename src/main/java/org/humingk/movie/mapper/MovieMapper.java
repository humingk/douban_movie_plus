package org.humingk.movie.mapper;

import java.util.List;

import org.humingk.movie.entity.*;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer movieId);

    int insert(Movie record);

    Movie selectByPrimaryKey(Integer movieId);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie record);

    // -----------------------

    List<Movie> selectMoviesByName(String name);

    List<Movie> selectMoviesByAlias(String name);

    Movie selectMovieBaseById(Integer movieId);

    List<Actor> selectDirectorsOfMovieById(Integer movieId);
    List<Actor> selectWritersOfMovieById(Integer movieId);
    List<Actor> selectLeadingactorsOfMovieById(Integer movieId);

    List<Type> selectTypesOfMovieById(Integer movieId);

    List<Tag> selectTagsOfMovieById(Integer movieId);

    List<Releasetime> selectReleasetimesOfMovieById(Integer movieId);
}