package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.PositiveOrZero;

/**
 * 知乎API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
@RequestMapping("/movie/zhihu")
public interface ZhihuApi {
    /**
     * 与豆瓣电影相关的知乎问题
     *
     * @param id     豆瓣电影ID
     * @param offset 偏移量（可选，默认0）
     * @param limit  限制数（可选，默认10）
     * @return
     */
    @GetMapping("questions")
    Result questions(@RequestParam("id") long id,
                     @RequestParam(value = "offset",
                             required = false,
                             defaultValue = "0") @PositiveOrZero int offset,
                     @RequestParam(value = "limit",
                             required = false,
                             defaultValue = "10") @PositiveOrZero int limit);
}
