package org.humingk.movie.api.celebrity;

import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbDetailsVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbVo;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * IMDB影人API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-celebrity")
public interface ImdbApi {
  /**
   * IMDB影人基础信息
   *
   * @param id IMDB影人ID
   * @return
   * @apiNote 简略
   */
  @RequestMapping(value = "/celebrity/imdb/bases", method = RequestMethod.GET)
  Result<CelebrityImdbVo> bases(@RequestParam("id") @NotNull Long id);

  /**
   * IMDB影人详细信息
   *
   * @param id IMDB影人ID
   * @return
   * @apiNote 包括影人基础信息，相关的IMDB电影
   */
  @RequestMapping(value = "/celebrity/imdb/details", method = RequestMethod.GET)
  Result<CelebrityImdbDetailsVo> details(@RequestParam("id") @NotNull Long id);
}
