package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieTag;

import java.util.List;

public interface MovieTagMapper {
    int deleteByPrimaryKey(@Param("tagId") Integer tagId, @Param("movieId") Integer movieId);

    int insert(MovieTag record);

    List<MovieTag> selectAll();

//    ----------------

    void updateMovieTagByMovieAll(@Param("tagId") Integer tagId, @Param("movieId") Integer movieId);

}
