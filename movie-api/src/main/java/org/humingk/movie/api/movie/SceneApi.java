package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电影场景API
 *
 * @author humingk
 */
@FeignClient("movie-server-movie")
public interface SceneApi {
    /**
     * 获取电影场景详情
     *
     * @param movieDoubanId 豆瓣电影ID
     * @param offset        偏移量（可选，默认0）
     * @param limit         限制数（可选，默认10）
     * @return
     */
    @GetMapping("scene_detail")
    Result sceneDetail(@RequestParam("movie_douban_id") long movieDoubanId,
                       @RequestParam(value = "offset",
                               required = false,
                               defaultValue = "0") int offset,
                       @RequestParam(value = "limit",
                               required = false,
                               defaultValue = "10") int limit);
}
