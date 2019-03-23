package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieComment;

public interface MovieCommentMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("commentId") Integer commentId);

    int insert(MovieComment record);

    List<MovieComment> selectAll();
}