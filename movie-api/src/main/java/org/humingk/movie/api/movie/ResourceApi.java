package org.humingk.movie.api.movie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

/**
 * 电影资源
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
public interface ResourceApi {
  //  /**
  //   * 电影资源
  //   *
  //   * @param id 豆瓣电影ID
  //   * @param limit 限制数（默认30）
  //   * @return
  //   * @since 2.0.0
  //   * @apiNote 包括正版资源、盗版资源、在线资源、离线资源
  //   */
  //  @RequestMapping(value = "/movie/resource/bases", method = RequestMethod.GET)
  //  Result<List<ResourceMovieVo>> bases(
  //      @RequestParam("id") @NotNull Long id,
  //      @RequestParam(value = "limit", required = false, defaultValue = "30") @PositiveOrZero
  //          Integer limit);
}
