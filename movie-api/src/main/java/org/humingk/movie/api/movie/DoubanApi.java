package org.humingk.movie.api.movie;

import org.humingk.movie.api.common.vo.movie.MovieDoubanDetailsVo;
import org.humingk.movie.api.common.vo.movie.MovieDoubanVo;
import org.humingk.movie.api.common.vo.share.ImageDoubanVo;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * 豆瓣电影API
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-movie")
public interface DoubanApi {

  /**
   * 豆瓣电影基础信息
   *
   * @param id 豆瓣电影ID
   * @return
   * @apiNote 包括电影海报, 电影简介等基础信息
   */
  @RequestMapping(value = "/movie/douban/bases", method = RequestMethod.GET)
  Result<MovieDoubanVo> bases(@RequestParam("id") @NotNull Long id);

  /**
   * 豆瓣电影详情信息
   *
   * @param id 豆瓣电影ID
   * @return
   * @apiNote 包括电影基础信息、评分信息、标签类型、相关影人基础信息、图片、预告片、热门影评短评、j奖项等
   */
  @RequestMapping(value = "/movie/douban/details", method = RequestMethod.GET)
  Result<MovieDoubanDetailsVo> details(@RequestParam("id") @NotNull Long id);

  /**
   * 豆瓣电影壁纸列表
   *
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @apiNote 包括图片ID等信息，以及壁纸的长与宽
   */
  @RequestMapping(value = "/movie/douban/wallpapers", method = RequestMethod.GET)
  Result<List<ImageDoubanVo>> wallpapers(
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);
}
