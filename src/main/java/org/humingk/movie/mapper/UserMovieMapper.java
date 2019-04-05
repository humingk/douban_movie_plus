package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserMovie;

import java.util.List;

public interface UserMovieMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("movieId") Integer movieId);

    int insert(UserMovie record);

    UserMovie selectByPrimaryKey(@Param("userId") Integer userId, @Param("movieId") Integer movieId);

    List<UserMovie> selectAll();

    int updateByPrimaryKey(UserMovie record);

//    ------------

    /**
     * 更新user_movie
     * @param userMovie
     */
    void updateWishsAndSeens(UserMovie userMovie);

    List<UserMovie> selectByUserId(int userId);

}