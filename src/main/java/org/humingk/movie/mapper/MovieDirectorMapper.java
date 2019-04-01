package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieDirector;

import java.util.List;

public interface MovieDirectorMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("directorId") Integer directorId);

    int insert(MovieDirector record);

    List<MovieDirector> selectAll();

//    ---------------

    /**
     * 根据movieAll更新关联表
     * @param movieId
     * @param directorId
     */
    void updateMovieDirectorByMovieAll(@Param("movieId") Integer movieId,@Param("directorId")Integer directorId);

}
