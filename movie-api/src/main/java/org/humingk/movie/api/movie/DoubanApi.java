package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

/**
 * 豆瓣电影API
 *
 * @author humingk
 */
@FeignClient("movie-server-movie")
@RequestMapping("/movie/douban")
public interface DoubanApi {

    /**
     * 豆瓣电影基础信息（包括电影海报、基础信息）
     *
     * @param id 豆瓣电影ID
     * @return
     */
    @GetMapping("bases")
    Result bases(@RequestParam("id") long id);

    /**
     * 豆瓣电影详情信息(包括电影海报、基础信息、剧情简介)
     *
     * @param id 豆瓣电影ID
     * @return
     */
    @GetMapping("details")
    Result details(@RequestParam("id") long id);

    /**
     * 豆瓣电影图片
     *
     * @param id 豆瓣电影ID
     * @return
     */
    @GetMapping("images")
    Result images(@RequestParam("id") long id);

    /**
     * 豆瓣电影热门短评
     *
     * @param id     豆瓣电影ID
     * @param offset 偏移量（可选，默认0）
     * @param limit  限制数（可选，默认10）
     * @return
     */
    @GetMapping("hot_comments")
    Result hotComments(@RequestParam("id") @NotBlank long id,
                       @RequestParam(value = "offset",
                               required = false,
                               defaultValue = "0") int offset,
                       @RequestParam(value = "limit",
                               required = false,
                               defaultValue = "10") int limit);

    /**
     * 豆瓣电影热门影评
     *
     * @param id     豆瓣电影ID
     * @param offset 偏移量（可选，默认0）
     * @param limit  限制数（可选，默认10）
     * @return
     */
    @GetMapping("reviews")
    Result reviews(@RequestParam("id") long id,
                   @RequestParam(value = "offset",
                           required = false,
                           defaultValue = "0") int offset,
                   @RequestParam(value = "limit",
                           required = false,
                           defaultValue = "10") int limit);

}
