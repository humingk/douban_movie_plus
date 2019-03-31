package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.*;

import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer movieId);

    int insert(Movie record);

    Movie selectByPrimaryKey(Integer movieId);

    List<Movie> selectAll();

    int updateByPrimaryKey(Movie record);

    // -----------------------

    /**
     * 更新电影评分
     * @param movieId
     * @param rate
     */
    void updateRateByPrimaryKey(@Param("movieId") Integer movieId, @Param("rate") float rate);

    List<Movie> selectMoviesByName(String name);

    List<Movie> selectMoviesByAlias(String name);

    /**
     * 根据电影名称开头的关键字模糊搜索
     * @param name
     * @return
     */
    List<Movie> selectMoviesByNameStart(String name);

    Movie selectMovieBaseById(Integer movieId);

    List<Actor> selectDirectorsOfMovieById(Integer movieId);
    List<Actor> selectWritersOfMovieById(Integer movieId);
    List<Actor> selectLeadingactorsOfMovieById(Integer movieId);

    List<Type> selectTypesOfMovieById(Integer movieId);

    List<Tag> selectTagsOfMovieById(Integer movieId);

    List<Releasetime> selectReleasetimesOfMovieById(Integer movieId);
}