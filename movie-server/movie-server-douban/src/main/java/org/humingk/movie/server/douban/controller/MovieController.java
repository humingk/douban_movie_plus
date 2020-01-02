package org.humingk.movie.server.douban.controller;

import org.humingk.movie.api.subject.api.MovieApi;
import org.humingk.movie.api.subject.model.MovieDoubanDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class MovieController implements MovieApi {

    @Autowired
    private MovieApi movieApi;

    /**
     * 豆瓣电影详细信息
     * <p>
     * 根据豆瓣电影ID获取电影的详细细信息
     *
     * @param movieDoubanId
     * @return
     */
    @Override
    @PostMapping(value = "movie_douban_detail")
    public MovieDoubanDetail movieDoubanDetail(int movieDoubanId) {
        return movieApi.movieDoubanDetail(movieDoubanId);
    }
}
