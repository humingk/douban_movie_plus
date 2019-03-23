package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Review;

public interface ReviewMapper {
    int deleteByPrimaryKey(Integer reviewId);

    int insert(Review record);

    Review selectByPrimaryKey(Integer reviewId);

    List<Review> selectAll();

    int updateByPrimaryKey(Review record);
}