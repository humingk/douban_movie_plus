package org.humingk.movie.api.celebrity;

import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanDetailsVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanVo;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * 豆瓣影人
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-celebrity")
public interface DoubanApi {

  /**
   * 豆瓣影人基础信息
   *
   * @param id 豆瓣影人ID
   * @return
   * @since 2.0.0
   * @apiNote 包括影人头像,影人简介等
   */
  @RequestMapping(value = "/celebrity/douban/bases", method = RequestMethod.GET)
  Result<CelebrityDoubanVo> bases(@RequestParam("id") @NotNull Long id);

  /**
   * 豆瓣影人详细信息
   *
   * @param id 豆瓣影人ID
   * @param limit 相关电影限制数(默认10)
   * @return
   * @since 2.0.0
   * @apiNote 包括影人基础信息，别称，图片，相关的豆瓣电影，获得的奖项
   */
  @RequestMapping(value = "/celebrity/douban/details", method = RequestMethod.GET)
  Result<CelebrityDoubanDetailsVo> details(
      @RequestParam("id") @NotNull Long id,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);

  // -----------------------

  /**
   * 豆瓣影人合作过的影人基础信息
   *
   * @param id 豆瓣影人ID
   * @param offset 合作次数偏移量（默认0）
   * @param limit 合作次数限制数（默认10）
   * @return
   * @since
   * @apiNote 包括影人照片、基础信息、相关电影基础信息（电影海报、基础信息）
   */
  @RequestMapping(value = "/celebrity/douban/cooperators_bases", method = RequestMethod.GET)
  Result cooperatorsBases(
      @RequestParam("id") Long id,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);
}
