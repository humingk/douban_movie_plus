package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieReview;

public interface MovieReviewMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("reviewId") Integer reviewId);

    int insert(MovieReview record);

    List<MovieReview> selectAll();
}