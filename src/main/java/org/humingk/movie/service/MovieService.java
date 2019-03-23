package org.humingk.movie.service;

import org.humingk.movie.entity.MovieAll;

import java.util.List;

public interface MovieService {

    /**
     * 根据电影名称找出电影所有的演员
     * @param s
     * @return
     */
    List<MovieAll> getMovieAllOfMovieByAlias(String s);
}
