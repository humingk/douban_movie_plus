package org.humingk.movie.api.music;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * 音乐API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-music")
public interface NeteaseApi {

  /**
   * 豆瓣电影网易云音乐相关播放信息
   *
   * @param id 豆瓣电影ID
   * @param songLimit 歌曲数目限制数（默认8）
   * @param playlistLimit 歌单数目限制数（默认1）
   * @param playlistSongLimit 歌单内歌曲数目限制数（默认8）
   * @param albumLimit 专辑数目限制数（默认1）
   * @param albumSongLimit 专辑内歌曲数目限制数（默认8）
   * @return
   */
  @RequestMapping(value = "/music/netease/plays", method = RequestMethod.GET)
  Result plays(
      @RequestParam("id") @NotNull Long id,
      @RequestParam(value = "songLimit", required = false, defaultValue = "8") @Positive
          Integer songLimit,
      @RequestParam(value = "playlistLimit", required = false, defaultValue = "1") @Positive
          Integer playlistLimit,
      @RequestParam(value = "playlistSongLimit", required = false, defaultValue = "8") @Positive
          Integer playlistSongLimit,
      @RequestParam(value = "albumLimit", required = false, defaultValue = "1") @Positive
          Integer albumLimit,
      @RequestParam(value = "albumSongLimit", required = false, defaultValue = "8") @Positive
          Integer albumSongLimit);

  /**
   * 网易云音乐热门评论
   *
   * @param id 网易云音乐歌曲ID
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认8）
   * @return
   */
  @RequestMapping(value = "/music/netease/hot_comments", method = RequestMethod.GET)
  Result hotComments(
      @RequestParam("id") @NotNull Long id,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "8") @PositiveOrZero
          Integer limit);
}
