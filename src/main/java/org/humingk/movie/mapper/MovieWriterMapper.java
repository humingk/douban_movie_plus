package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieWriter;

import java.util.List;

public interface MovieWriterMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("writerId") Integer writerId);

    int insert(MovieWriter record);

    List<MovieWriter> selectAll();

    //    ---------------

    /**
     * 根据movieAll更新关联表
     * @param movieId
     * @param writerId
     */
    void updateMovieWriterByMovieAll(@Param("movieId") Integer movieId,@Param("writerId")Integer writerId);

}