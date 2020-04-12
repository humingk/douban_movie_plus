package org.humingk.movie.api.movie;

import org.humingk.movie.api.common.vo.movie.MovieImdbDetailsVo;
import org.humingk.movie.api.common.vo.movie.MovieImdbVo;
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
 * IMDB电影
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
public interface ImdbApi {

  /**
   * IMDB电影基础信息
   *
   * @param id IMDB电影ID
   * @return
   * @apiNote 包括电影海报、电影简介等
   */
  @RequestMapping(value = "/movie/imdb/bases", method = RequestMethod.GET)
  Result<MovieImdbVo> bases(@RequestParam("id") @NotNull Long id);

  /**
   * IMDB电影详情信息
   *
   * @param id IMDB电影ID
   * @return
   * @apiNote 包括电影基础信息、评分、相关影人信息等
   */
  @RequestMapping(value = "/movie/imdb/details", method = RequestMethod.GET)
  Result<MovieImdbDetailsVo> details(@RequestParam("id") @NotNull Long id);
}
