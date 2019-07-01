package org.humingk.movie.service;

import org.humingk.movie.common.MovieAll;
import org.humingk.movie.entity.Movie;

import java.util.List;

/**
 * @author humingk
 */
public interface MovieService {

    /**
     * 根据电影Id找出电影的详细资料
     *
     * @param movieId
     * @return
     */
    MovieAll getMovieAllByMovieId(int movieId);

    /**
     * 根据电影名称找出所有电影所有的详细资料
     *
     * @param s
     * @param start
     * @param count
     * @return
     */
    List<MovieAll> getMovieAllsOfMovieByAlias(String s, int start, int count);

    /**
     * 根据电影名称开头的字符串找出所有电影的基本资料
     *
     * @param s
     * @return
     */
    List<Movie> getMoviesByNameStart(String s);


    /**
     * 更新电影评分
     *
     * @param movieId
     * @param rate
     */
    boolean updateRateByMovieId(int movieId, float rate);

    /**
     * 更新imdbId
     *
     * @param movieId
     * @param imdbId
     * @return
     */
    boolean updateImdbIdByMovieId(int movieId, String imdbId);


    /**
     * 向数据库添加movieAll
     *
     * @param movieAll
     * @return
     */
    Boolean addMovieAll(MovieAll movieAll);

}

