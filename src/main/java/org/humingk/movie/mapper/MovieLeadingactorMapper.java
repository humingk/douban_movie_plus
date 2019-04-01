package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieLeadingactor;

import java.util.List;

public interface MovieLeadingactorMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("leadingactorId") Integer leadingactorId);

    int insert(MovieLeadingactor record);

    List<MovieLeadingactor> selectAll();

//    ------------

    void updateMovieLeadingactorByMovieAll(@Param("movieId") Integer movieId, @Param("leadingactorId") Integer leadingactorId);
}