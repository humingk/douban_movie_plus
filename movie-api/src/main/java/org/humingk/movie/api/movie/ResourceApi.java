package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电影资源API
 *
 * @author humingk
 */
@FeignClient("movie-server-movie")
public interface ResourceApi {
    /**
     * 获取电影资源（包括正版资源、盗版资源、在线资源、离线资源）
     *
     * @param movieDoubanId 豆瓣电影ID
     * @param offset        偏移量（可选，默认0）
     * @param limit         限制数（可选，默认10）
     * @return
     */
    @GetMapping("resource_movie")
    Result resourceMovie(@RequestParam("movie_douban_id") long movieDoubanId,
                         @RequestParam(value = "offset",
                                 required = false,
                                 defaultValue = "0") int offset,
                         @RequestParam(value = "limit",
                                 required = false,
                                 defaultValue = "10") int limit);

}
