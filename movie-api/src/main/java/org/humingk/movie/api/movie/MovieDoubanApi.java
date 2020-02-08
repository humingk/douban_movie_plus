package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * 豆瓣电影API
 *
 * @author humingk
 */
@Validated
@FeignClient( value = "movie-server-movie")
public interface MovieDoubanApi {

    /**
     * 豆瓣电影基础信息（包括电影海报、基础信息）
     *
     * @param id 豆瓣电影ID
     * @return
     */
    @GetMapping("bases")
    Result bases(@RequestParam("id") long id);


    /**
     * 豆瓣电影基础信息列表（包括电影海报、基础信息）
     *
     * @param idList 豆瓣电影ID列表(Json字符串)
     * @return
     */
    @GetMapping("bases_list")
    Result basesList(@RequestBody @NotEmpty List<Long> idList);

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
    Result hotComments(@RequestParam("id") long id,
                       @RequestParam(value = "offset",
                               required = false,
                               defaultValue = "0") @PositiveOrZero int offset,
                       @RequestParam(value = "limit",
                               required = false,
                               defaultValue = "10") @PositiveOrZero int limit);

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
                           defaultValue = "0") @PositiveOrZero int offset,
                   @RequestParam(value = "limit",
                           required = false,
                           defaultValue = "10") @PositiveOrZero int limit);

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
    @GetMapping("search/tips")
    Result searchTips(@RequestParam("keyword") @NotBlank String keyword,
                @RequestParam(value = "offset",
                        required = false,
                        defaultValue = "0") @PositiveOrZero int offset,
                @RequestParam(value = "limit",
                        required = false,
                        defaultValue = "10") @PositiveOrZero int limit);

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
    @GetMapping("search/details")
    Result searchDetails(@RequestParam("keyword") @NotBlank String keyword,
                   @RequestParam(value = "offset",
                           required = false,
                           defaultValue = "0") @PositiveOrZero int offset,
                   @RequestParam(value = "limit",
                           required = false,
                           defaultValue = "10") @PositiveOrZero int limit);

}
