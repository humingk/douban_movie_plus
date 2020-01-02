package org.humingk.movie.api.subject.api;

import org.humingk.movie.api.subject.model.MovieDoubanDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电影API
 *
 * @author humingk
 */
@FeignClient("movie-service-douban")
public interface MovieApi {
    /**
     * 豆瓣电影详细信息
     * <p>
     * 根据豆瓣电影ID获取电影的详细细信息
     *
     * @param movieDoubanId
     * @return
     */
    @PostMapping(value = "movie_douban_detail")
    MovieDoubanDetail movieDoubanDetail(@RequestParam("movie_douban_id") int movieDoubanId);
}
