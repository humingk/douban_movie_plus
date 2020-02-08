package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电影模块评分API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
@RequestMapping("/movie/rate")
public interface RateApi {
    /**
     * 电影所有评分信息(包括豆瓣、IMDB、MTC、猫眼、知乎、烂番茄新鲜度等)
     *
     * @param id 豆瓣电影ID
     * @return
     */
    @GetMapping("details")
    Result details(@RequestParam("id") long id);
}
