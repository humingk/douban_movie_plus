package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

// 用于生成API文档
//import org.springframework.web.bind.annotation.RestController;
//@RestController

/**
 * IMDB电影API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
public interface ImdbApi {

    /**
     * IMDB电影详情信息
     *
     * @param id 电影豆瓣ID
     * @return
     * @apiNote 包括电影海报、包括基础信息、剧情简介
     */
    @RequestMapping(value = "/movie/imdb/details", method = RequestMethod.GET)
    Result details(@RequestParam("id") @NotNull Long id);
}
