package org.humingk.movie.api.music;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * 音乐API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-music")
@RequestMapping("/music/netease")
public interface NeteaseApi {

    /**
     * 获取与豆瓣电影相关的网易云音乐播放信息
     *
     * @param id                豆瓣电影ID
     * @param songLimit         歌曲数目限制数（可选，默认8）
     * @param playlistLimit     歌单数目限制数（可选，默认1）
     * @param playlistSongLimit 歌单内歌曲数目限制数（可选，默认8）
     * @param albumLimit        专辑数目限制数（可选，默认1）
     * @param albumSongLimit    专辑内歌曲数目限制数（可选，默认8）
     * @return
     */
    @GetMapping("plays")
    Result plays(@RequestParam("id") long id,
                 @RequestParam(value = "song_limit",
                         required = false,
                         defaultValue = "8") @Positive int songLimit,
                 @RequestParam(value = "playlist_limit",
                         required = false,
                         defaultValue = "1") @Positive int playlistLimit,
                 @RequestParam(value = "playlist_song_limit",
                         required = false,
                         defaultValue = "8") @Positive int playlistSongLimit,
                 @RequestParam(value = "album_limit",
                         required = false,
                         defaultValue = "1") @Positive int albumLimit,
                 @RequestParam(value = "album_song_limit",
                         required = false,
                         defaultValue = "8") @Positive int albumSongLimit);

    /**
     * 获取网易云音乐热门评论
     *
     * @param id     网易云音乐歌曲ID
     * @param offset 偏移量（可选，默认0）
     * @param limit  限制数（可选，默认8）
     * @return
     */
    @GetMapping("hot_comments")
    Result hotComments(@RequestParam("id") long id,
                       @RequestParam(value = "offset",
                               required = false,
                               defaultValue = "0") @PositiveOrZero int offset,
                       @RequestParam(value = "limit",
                               required = false,
                               defaultValue = "8") @PositiveOrZero int limit);
}
