package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 电影API
 *
 * @author humingk
 */
@FeignClient("movie-server-movie")
public interface MovieApi {

    /**
     * 获取豆瓣电影基础信息（包括电影海报、基础信息）
     *
     * @param movieDoubanId 豆瓣电影ID
     * @return
     */
    @GetMapping("movie_douban_base")
    Result movieDoubanBase(@RequestParam("movie_douban_id") long movieDoubanId);

    /**
     * 获取豆瓣电影详情信息(包括电影海报、基础信息、剧情简介)
     *
     * @param movieDoubanId 豆瓣电影ID
     * @return
     */
    @GetMapping("movie_douban_detail")
    Result movieDoubanDetail(@RequestParam("movie_douban_id") long movieDoubanId);

    /**
     * 获取IMDB电影详情信息(包括电影海报、包括基础信息、剧情简介)
     *
     * @param movieDoubanId 豆瓣电影ID
     * @return
     */
    @GetMapping("movie_imdb_detail")
    Result movieImdbDetail(@RequestParam("movie_douban_id") long movieDoubanId);

    /**
     * 获取豆瓣电影图片
     *
     * @param movieDoubanId 豆瓣电影ID
     * @return
     */
    @GetMapping("image_movie_douban")
    Result imageMovieDouban(@RequestParam("movie_douban_id") long movieDoubanId);

    /**
     * 获取豆瓣电影热门短评
     *
     * @param movieDoubanId 豆瓣电影ID
     * @param offset        偏移量（可选，默认0）
     * @param limit         限制数（可选，默认10）
     * @return
     */
    @GetMapping("comment_movie_douban")
    Result commentMovieDouban(@RequestParam("movie_douban_id") long movieDoubanId,
                              @RequestParam(value = "offset",
                                      required = false,
                                      defaultValue = "0") int offset,
                              @RequestParam(value = "limit",
                                      required = false,
                                      defaultValue = "10") int limit);

    /**
     * 获取豆瓣电影热门影评
     *
     * @param movieDoubanId 豆瓣电影ID
     * @param offset        偏移量（可选，默认0）
     * @param limit         限制数（可选，默认10）
     * @return
     */
    @GetMapping("review_movie_douban")
    Result reviewMovieDouban(@RequestParam("movie_douban_id") long movieDoubanId,
                             @RequestParam(value = "offset",
                                     required = false,
                                     defaultValue = "0") int offset,
                             @RequestParam(value = "limit",
                                     required = false,
                                     defaultValue = "10") int limit);


}
