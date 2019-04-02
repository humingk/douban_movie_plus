package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserMovie;

public interface UserMovieMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("movieId") Integer movieId);

    int insert(UserMovie record);

    UserMovie selectByPrimaryKey(@Param("userId") Integer userId, @Param("movieId") Integer movieId);

    List<UserMovie> selectAll();

    int updateByPrimaryKey(UserMovie record);
}