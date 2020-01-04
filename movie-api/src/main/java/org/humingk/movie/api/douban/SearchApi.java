package org.humingk.movie.api.douban;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 豆瓣模块搜索API
 *
 * @author humingk
 */
@FeignClient("movie-server-douban")
public interface SearchApi {
    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword
     * @return
     */
    @PostMapping("search_movie_tips")
    Result searchMovieTips(@RequestParam("keyword") String keyword);
}
