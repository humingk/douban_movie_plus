package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserReview;

public interface UserReviewMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("reviewId") Integer reviewId);

    int insert(UserReview record);

    List<UserReview> selectAll();
}