package org.humingk.movie.api.movie;

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
 * 电影模块评分API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
public interface RateApi {
  /**
   * 电影评分信息
   *
   * @param id 电影豆瓣ID
   * @return
   * @apiNote 包括豆瓣、IMDB、MTC、猫眼、知乎、烂番茄新鲜度等
   */
  @RequestMapping(value = "/movie/rate/details", method = RequestMethod.GET)
  Result details(@RequestParam("id") @NotNull Long id);
}
