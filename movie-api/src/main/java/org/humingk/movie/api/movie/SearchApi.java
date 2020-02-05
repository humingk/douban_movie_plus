package org.humingk.movie.api.movie;

import org.humingk.movie.api.movie.hystric.SearchApiHystric;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电影模块搜索API
 *
 * @author humingk
 */
@FeignClient(value = "movie-server-movie", fallback = SearchApiHystric.class)
public interface SearchApi {
    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword 搜索关键字
     * @param offset  偏移量（可选，默认0）
     * @param limit   限制数（可选，默认10）
     * @return
     */
    @GetMapping("search_movie_tips")
    Result searchMovieTips(@RequestParam("keyword") String keyword,
                           @RequestParam(value = "offset",
                                   required = false,
                                   defaultValue = "0") int offset,
                           @RequestParam(value = "limit",
                                   required = false,
                                   defaultValue = "10") int limit);

    /**
     * 豆瓣电影搜索结果
     * <p>
     * 根据电影名称字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword 搜索关键字
     * @param offset  偏移量（可选，默认0）
     * @param limit   限制数（可选，默认10）
     * @return
     */
    @GetMapping("search_movie_details")
    Result searchMovieDetails(@RequestParam("keyword") String keyword,
                             @RequestParam(value = "offset",
                                     required = false,
                                     defaultValue = "0") int offset,
                             @RequestParam(value = "limit",
                                     required = false,
                                     defaultValue = "10") int limit);

    /**
     * 豆瓣影人搜索结果
     * <p>
     * 根据影人名称字符串找出豆瓣影人的基本信息列表
     *
     * @param keyword 搜索关键字
     * @param offset  偏移量（可选，默认0）
     * @param limit   限制数（可选，默认10）
     * @return
     */
    @GetMapping("search_celebrity_details")
    Result searchCelebrityDetails(@RequestParam("keyword") String keyword,
                                 @RequestParam(value = "offset",
                                         required = false,
                                         defaultValue = "0") int offset,
                                 @RequestParam(value = "limit",
                                         required = false,
                                         defaultValue = "10") int limit);
}
