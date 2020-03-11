package org.humingk.movie.api.search;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/**
 * Plus搜索API
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-search")
public interface SearchApi {
  /**
   * Plus搜索提示
   *
   * @param keyword 搜索关键字
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @apiNote 根据名称开头的字符串找出豆瓣电影、豆瓣影人、网易云音乐等基本信息列表
   */
  @RequestMapping(value = "/search/tips", method = RequestMethod.GET)
  Result tips(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);

  /**
   * Plus搜索结果
   *
   * @param keyword 搜索关键字
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @apiNote 根据名称字符串找出豆瓣电影、豆瓣影人、网易云音乐等基本信息列表
   */
  @RequestMapping(value = "/search/details", method = RequestMethod.GET)
  Result details(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);
}
