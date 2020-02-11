package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

// 用于生成API文档
//import org.springframework.web.bind.annotation.RestController;
//@RestController

/**
 * 知乎API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
public interface ZhihuApi {
    /**
     * 与豆瓣电影相关的知乎问题
     *
     * @param id     电影豆瓣ID
     * @param offset 偏移量（默认0）
     * @param limit  限制数（默认10）
     * @return
     */
    @RequestMapping(value = "/movie/zhihu/questions", method = RequestMethod.GET)
    Result questions(@RequestParam("id") @NotNull Long id,
                     @RequestParam(value = "offset",
                             required = false,
                             defaultValue = "0") @PositiveOrZero Integer offset,
                     @RequestParam(value = "limit",
                             required = false,
                             defaultValue = "10") @PositiveOrZero Integer limit);
}
