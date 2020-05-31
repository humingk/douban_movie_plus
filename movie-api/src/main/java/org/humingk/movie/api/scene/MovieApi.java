package org.humingk.movie.api.scene;

import org.humingk.movie.api.common.vo.MovieSceneAllVo;
import org.humingk.movie.api.common.vo.MovieSceneBriefVo;
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
 * 电影场景
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-scene")
public interface MovieApi {
  /**
   * 电影场景简略信息
   *
   * @param id 豆瓣电影ID
   * @return
   * @since 2.0.0
   * @apiNote 包括场景电影基础信息，分布图，场景地点简略信息，场景地点图等
   */
  @RequestMapping(value = "/scene/fotoplace/bases", method = RequestMethod.GET)
  Result<MovieSceneBriefVo> bases(@RequestParam("id") @NotNull Long id);

  /**
   * 电影场景详细信息
   *
   * @param id 豆瓣电影ID
   * @return
   * @since 2.0.0
   * @apiNote 包括场景电影基础信息，分布图，场景详细信息,场景地点详细信息，场景图片等
   */
  @RequestMapping(value = "/scene/fotoplace/details", method = RequestMethod.GET)
  Result<MovieSceneAllVo> details(@RequestParam("id") @NotNull Long id);
}
