package org.humingk.movie.api.douban.api;

import org.humingk.common.entity.MovieDouban;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author humingk
 */
public interface SearchApi {
    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出电影的基本信息列表
     *
     * @param params
     * @return
     */

    @PostMapping(value = "search_movie_tips")
    List<MovieDouban> searchMovieTips(@RequestParam("params") String params);

}
