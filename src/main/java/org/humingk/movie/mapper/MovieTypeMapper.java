package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieType;

import java.util.List;

public interface MovieTypeMapper {
    int deleteByPrimaryKey(@Param("typeId") Integer typeId, @Param("movieId") Integer movieId);

    int insert(MovieType record);

    List<MovieType> selectAll();

    void updateMovieTypeByMovieAll(@Param("typeId") Integer typeId, @Param("movieId") Integer movieId);
}