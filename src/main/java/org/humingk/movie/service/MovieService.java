package org.humingk.movie.service;

import org.humingk.movie.entity.Movie;
import org.humingk.movie.entity.MovieAll;

import java.util.List;

/**
 * @author humin
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
     * @param s
     * @return
     */
    List<MovieAll> getMovieAllsOfMovieByAlias(String s);

    /**
     * 根据电影名称开头的字符串找出所有电影的基本资料
     * @param s
     * @return
     */
    List<Movie> getMoviesByNameStart(String s);
}

