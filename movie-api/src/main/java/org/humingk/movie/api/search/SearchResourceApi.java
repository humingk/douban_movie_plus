package org.humingk.movie.api.search;

import org.humingk.movie.api.common.vo.ResourceMovieVo;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * 电影资源搜索
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-search")
public interface SearchResourceApi {
  /**
   * 资源搜索结果
   *
   * @param keyword 搜索关键字
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @since 2.0.7
   * @apiNote 根据电影名关键字匹配电影资源列表
   */
  @RequestMapping(value = "/search/resource/details", method = RequestMethod.GET)
  Result<List<ResourceMovieVo>> details(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);
}
