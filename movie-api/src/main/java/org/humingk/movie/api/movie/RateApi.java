package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电影模块评分API
 *
 * @author humingk
 */
@FeignClient("movie-server-movie")
public interface RateApi {
    /**
     * 获取电影所有评分信息(包括豆瓣、IMDB、MTC、猫眼、知乎、烂番茄新鲜度等)
     *
     * @param movieDoubanId 豆瓣电影ID
     * @return
     */
    @GetMapping("get_all_rate")
    Result allRate(@RequestParam("movie_douban_id") long movieDoubanId);
}
