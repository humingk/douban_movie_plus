package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieDirector;

public interface MovieDirectorMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("directorId") Integer directorId);

    int insert(MovieDirector record);

    List<MovieDirector> selectAll();
}