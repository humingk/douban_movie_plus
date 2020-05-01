package org.humingk.movie.api.movie;

import org.humingk.movie.api.common.vo.MovieDetailsVo;
import org.humingk.movie.api.common.vo.MovieVo;
import org.humingk.movie.api.common.vo.RateMovieVo;
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
 * 电影集合
 *
 * @author humingk
 * @since 2.0.0
 */
@Validated
@FeignClient(value = "movie-server-movie")
public interface MovieApi {
  /**
   * 电影基础信息
   *
   * @param id 豆瓣电影ID
   * @return
   * @since 2.0.0
   * @apiNote 豆瓣电影和IMDB电影,包括电影海报, 电影简介等基础信息
   */
  @RequestMapping(value = "/movie/bases", method = RequestMethod.GET)
  Result<MovieVo> bases(@RequestParam("id") @NotNull Long id);

  /**
   * 电影详情信息
   *
   * @param id 豆瓣电影ID
   * @return
   * @since 2.0.0
   * @apiNote 豆瓣电影和IMDB电影,包括电影基础信息、评分信息、标签类型、相关影人基础信息、图片、预告片、热门影评短评、奖项等
   */
  @RequestMapping(value = "/movie/details", method = RequestMethod.GET)
  Result<MovieDetailsVo> details(@RequestParam("id") @NotNull Long id);

  /**
   * 电影评分信息
   *
   * @param id 豆瓣电影ID
   * @return
   * @since 2.0.7
   * @apiNote 包括豆瓣电影评分、IMDB评分、烂番茄新鲜度、MTC评分、猫眼评分、知乎推荐度等
   */
  @RequestMapping(value = "/movie/rate/details", method = RequestMethod.GET)
  Result<RateMovieVo> rateDetails(@RequestParam("id") @NotNull Long id);
}
