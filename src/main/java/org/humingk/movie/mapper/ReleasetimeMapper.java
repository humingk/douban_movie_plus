package org.humingk.movie.mapper;

import org.humingk.movie.entity.Releasetime;

import java.util.List;

public interface ReleasetimeMapper {
    int deleteByPrimaryKey(Integer releasetimeId);

    int insert(Releasetime record);

    Releasetime selectByPrimaryKey(Integer releasetimeId);

    List<Releasetime> selectAll();

    int updateByPrimaryKey(Releasetime record);

    //    =====================

    List<Releasetime> selectReleasetimesOfMovieById(Integer movieId);

    Releasetime selectByreleasetimeTimeArea(String timeArea);

    int updateReleasetimesByMovieAll(Releasetime releasetime);
}