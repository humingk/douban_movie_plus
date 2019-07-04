package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.*;

import java.util.List;

public interface MovieMapper {
    /**
     * 更新电影评分
     *
     * @param movieId
     * @param rate
     */
    void updateRateByPrimaryKey(@Param("movieId") Integer movieId, @Param("rate") float rate);

    /**
     * 更新 imdbId
     *
     * @param movieId
     * @param imdbId
     */
    void updateImdbIdByPrimaryKey(@Param("movieId") Integer movieId, @Param("imdbId") String imdbId);


    /**
     * 更新电影基本资料
     *
     * @param movieId
     * @param name
     * @param rate
     * @param imdbId
     * @param alias
     */
    void updateMovieBaseByMovieAll(@Param("movieId") Integer movieId, @Param("name") String name,
                                   @Param("rate") float rate, @Param("imdbId") String imdbId,
                                   @Param("alias") String alias);

    /**
     * 根据 部分电影名称 别称开头的关键字搜索 movieAll
     *
     * @param name
     * @param start
     * @param count
     * @return
     */
    List<Movie> selectMoviesByAlias(@Param("name") String name, @Param("start") int start, @Param("count") int count);

    /**
     * 根据电影名称开头的关键字模糊搜索
     *
     * @param name
     * @return
     */
    List<Movie> selectMoviesByNameStart(String name);

    /**
     * 根据电影ID查找指定地电影
     *
     * @param movieId
     * @return
     */
    Movie selectMovieBaseById(Integer movieId);

    /**
     * 根据actorId获取电影列表
     *
     * @return
     */

    List<Movie> selectMoviesByDirectorId(@Param("actorId") Integer actorId);

    List<Movie> selectMoviesByWriterId(@Param("actorId") Integer actorId);

    List<Movie> selectMoviesByLeadingactorId(@Param("actorId") Integer actorId);

}