package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserComment;

public interface UserCommentMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("commentId") Integer commentId);

    int insert(UserComment record);

    List<UserComment> selectAll();
}