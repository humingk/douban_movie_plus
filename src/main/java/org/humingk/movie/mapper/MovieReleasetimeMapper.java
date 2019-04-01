package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieReleasetime;

import java.util.List;

public interface MovieReleasetimeMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("releasetimeId") Integer releasetimeId);

    int insert(MovieReleasetime record);

    List<MovieReleasetime> selectAll();

//    ------------------

    void updateMovieReleasetimeByMovieAll(@Param("movieId") Integer movieId, @Param("releasetimeId") Integer releasetimeId);
}