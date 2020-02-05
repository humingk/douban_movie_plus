package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * IMDB电影API
 *
 * @author humingk
 */
@FeignClient("movie-server-movie")
@RequestMapping("/movie/imdb")
public interface ImdbApi {

    /**
     * IMDB电影详情信息(包括电影海报、包括基础信息、剧情简介)
     *
     * @param id 豆瓣电影ID
     * @return
     */
    @GetMapping("details")
    Result details(@RequestParam("id") long id);
}
