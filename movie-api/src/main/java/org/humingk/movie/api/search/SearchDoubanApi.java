package org.humingk.movie.api.search;

import org.humingk.movie.api.common.vo.SearchResultDoubanVo;
import org.humingk.movie.api.common.vo.SearchTipsDoubanVo;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController
/**
 * 豆瓣搜索
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-search")
public interface SearchDoubanApi {
  /**
   * 豆瓣搜索提示
   *
   * @param keyword 搜索关键字
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @apiNote 根据名称开头的字符串找出豆瓣电影、豆瓣影人等基本信息列表
   */
  @RequestMapping(value = "/search/douban/tips", method = RequestMethod.GET)
  Result<SearchTipsDoubanVo> tips(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);

  /**
   * 豆瓣搜索结果
   *
   * @param keyword 搜索关键字
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @apiNote 根据名称字符串找出豆瓣电影、豆瓣影人等基本信息列表
   */
  @RequestMapping(value = "/search/douban/details", method = RequestMethod.GET)
  Result<SearchResultDoubanVo> details(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);
}
