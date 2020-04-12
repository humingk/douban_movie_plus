package org.humingk.movie.api.movie;

import org.humingk.movie.api.common.vo.ZhihuVo;
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
 * 知乎电影
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
public interface ZhihuApi {
  /**
   * 豆瓣电影知乎相关
   *
   * @param id 豆瓣电影ID
   * @return
   * @apiNote 包括知乎话题、知乎评分、猫眼评分、知乎问题列表等
   */
  @RequestMapping(value = "/movie/zhihu/bases", method = RequestMethod.GET)
  Result<ZhihuVo> bases(@RequestParam("id") @NotNull Long id);
}
