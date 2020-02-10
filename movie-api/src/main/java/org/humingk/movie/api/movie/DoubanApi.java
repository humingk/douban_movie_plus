package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//import org.springframework.web.bind.annotation.RestController;
//@RestController

/**
 * 豆瓣电影API
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-movie")
public interface DoubanApi {

    /**
     * 豆瓣电影基础信息（包括电影海报、基础信息）
     *
     * @param id 电影豆瓣ID
     * @return
     */
    @RequestMapping(value = "/movie/douban/bases", method = RequestMethod.GET)
    Result bases(@RequestParam("id") @NotNull Long id);


    /**
     * 豆瓣电影基础信息列表（包括电影海报、基础信息）
     *
     * @param idList 电影豆瓣ID列表(Json字符串)
     * @return
     */
    @RequestMapping(value = "/movie/douban/bases_list", method = RequestMethod.GET, consumes = APPLICATION_JSON_VALUE)
    Result basesList(@RequestBody @NotEmpty List<Long> idList);

    /**
     * 豆瓣电影详情信息(包括电影海报、基础信息、剧情简介)
     *
     * @param id 电影豆瓣ID
     * @return
     */
    @RequestMapping(value = "/movie/douban/details", method = RequestMethod.GET)
    Result details(@RequestParam("id") @NotNull Long id);

    /**
     * 豆瓣电影图片
     *
     * @param id 电影豆瓣ID
     * @return
     */
    @RequestMapping(value = "/movie/douban/images", method = RequestMethod.GET)
    Result images(@RequestParam("id") @NotNull Long id);

    /**
     * 豆瓣电影热门短评
     *
     * @param id     电影豆瓣ID
     * @param offset 偏移量（默认0）
     * @param limit  限制数（默认10）
     * @return
     */
    @RequestMapping(value = "/movie/douban/hot_comments", method = RequestMethod.GET)
    Result hotComments(@RequestParam("id") @NotNull Long id,
                       @RequestParam(value = "offset",
                               required = false,
                               defaultValue = "0") @PositiveOrZero Integer offset,
                       @RequestParam(value = "limit",
                               required = false,
                               defaultValue = "10") @PositiveOrZero Integer limit);

    /**
     * 豆瓣电影热门影评
     *
     * @param id     电影豆瓣ID
     * @param offset 偏移量（默认0）
     * @param limit  限制数（默认10）
     * @return
     */
    @RequestMapping(value = "/movie/douban/hot_reviews", method = RequestMethod.GET)
    Result hotReviews(@RequestParam("id") Long id,
                      @RequestParam(value = "offset",
                              required = false,
                              defaultValue = "0") @PositiveOrZero Integer offset,
                      @RequestParam(value = "limit",
                              required = false,
                              defaultValue = "10") @PositiveOrZero Integer limit);

    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword 搜索关键字
     * @param offset  偏移量（默认0）
     * @param limit   限制数（默认10）
     * @return
     */
    @RequestMapping(value = "/movie/douban/search_tips", method = RequestMethod.GET)
    Result searchTips(@RequestParam("keyword") @NotBlank String keyword,
                      @RequestParam(value = "offset",
                              required = false,
                              defaultValue = "0") @PositiveOrZero Integer offset,
                      @RequestParam(value = "limit",
                              required = false,
                              defaultValue = "10") @PositiveOrZero Integer limit);

    /**
     * 豆瓣电影搜索结果
     * <p>
     * 根据电影名称字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword 搜索关键字
     * @param offset  偏移量（默认0）
     * @param limit   限制数（默认10）
     * @return
     */
    @RequestMapping(value = "/movie/douban/search_details", method = RequestMethod.GET)
    Result searchDetails(@RequestParam("keyword") @NotBlank String keyword,
                         @RequestParam(value = "offset",
                                 required = false,
                                 defaultValue = "0") @PositiveOrZero Integer offset,
                         @RequestParam(value = "limit",
                                 required = false,
                                 defaultValue = "10") @PositiveOrZero Integer limit);

}
