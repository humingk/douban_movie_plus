package org.humingk.movie.api.celebrity;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * 豆瓣影人API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-celebrity")
@RequestMapping("/celebrity/douban")
public interface DoubanApi {

    /**
     * 豆瓣影人基础信息(包括影人图片)
     *
     * @param id 豆瓣影人ID
     * @return
     */
    @GetMapping("bases")
    Result bases(@RequestParam("id") long id);

    /**
     * 豆瓣影人基础信息列表(包括影人图片)
     *
     * @param idList 豆瓣影人ID列表(Json字符串)
     * @return
     */
    @GetMapping("bases_list")
    Result basesList(@RequestBody @NotEmpty List<Long> idList);

    /**
     * 豆瓣影人详细信息（包括影人图片、基础信息、参演电影基础信息（电影海报、基础信息）、影人简介）
     *
     * @param id 豆瓣影人ID
     * @return
     */
    @GetMapping("details")
    Result details(@RequestParam("id") long id);

    /**
     * 豆瓣影人奖项（包括电影基础信息、奖项信息）
     *
     * @param id
     * @param offset 偏移量（可选，默认0）
     * @param limit  限制数（可选，默认10）
     * @return
     */
    @GetMapping("awards")
    Result awards(@RequestParam("id") long id,
                  @RequestParam(value = "offset",
                          required = false,
                          defaultValue = "0") @PositiveOrZero int offset,
                  @RequestParam(value = "limit",
                          required = false,
                          defaultValue = "10") @PositiveOrZero int limit);

    /**
     * 豆瓣影人合作过的影人基础信息（包括影人照片、基础信息）及其相关电影基础信息（包括电影海报、基础信息）
     *
     * @param id     豆瓣影人ID
     * @param offset 合作次数偏移量（可选，默认0）
     * @param limit  合作次数限制数（可选，默认10）
     * @return
     */
    @GetMapping("cooperators/bases")
    Result cooperatorsBases(@RequestParam("id") long id,
                            @RequestParam(value = "offset",
                                    required = false,
                                    defaultValue = "0") @PositiveOrZero int offset,
                            @RequestParam(value = "limit",
                                    required = false,
                                    defaultValue = "10") @PositiveOrZero int limit);

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
    @GetMapping("search/details")
    Result searchDetails(@RequestParam("keyword") @NotBlank String keyword,
                         @RequestParam(value = "offset",
                                 required = false,
                                 defaultValue = "0") @PositiveOrZero int offset,
                         @RequestParam(value = "limit",
                                 required = false,
                                 defaultValue = "10") @PositiveOrZero int limit);
}
