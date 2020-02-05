package org.humingk.movie.api.music;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 音乐API
 *
 * @author humingk
 */
@FeignClient("movie-server-music")
public interface MusicApi {

    /**
     * 获取与豆瓣电影相关的网易云音乐播放信息
     *
     * @param movieDoubanId        豆瓣电影ID
     * @param songLimit            歌曲数目限制数（可选，默认8）
     * @param playlistLimit        歌单数目限制数（可选，默认1）
     * @param playlistContetnLimit 歌单内歌曲数目限制数（可选，默认8）
     * @param albumLimit           专辑数目限制数（可选，默认1）
     * @param albumContentLimit    专辑内歌曲数目限制数（可选，默认8）
     * @return
     */
    @GetMapping("netease_music_resources")
    Result neteaseMusicResources(@RequestParam("movie_douban_id") long movieDoubanId,
                                 @RequestParam(value = "song_limit",
                                         required = false,
                                         defaultValue = "8") int songLimit,
                                 @RequestParam(value = "playlist_limit",
                                         required = false,
                                         defaultValue = "1") int playlistLimit,
                                 @RequestParam(value = "playlist_content_limit",
                                         required = false,
                                         defaultValue = "8") int playlistContetnLimit,
                                 @RequestParam(value = "album_limit",
                                         required = false,
                                         defaultValue = "1") int albumLimit,
                                 @RequestParam(value = "album_content_limit",
                                         required = false,
                                         defaultValue = "8") int albumContentLimit);

    /**
     * 获取网易云音乐热门评论
     *
     * @param musicNeteaseId 网易云音乐歌曲ID
     * @param offset         偏移量（可选，默认0）
     * @param limit          限制数（可选，默认8）
     * @return
     */
    @GetMapping("netease_music_hot_comments")
    Result neteaseMusicHotComments(@RequestParam("music_netease_id") long musicNeteaseId,
                                   @RequestParam(value = "offset",
                                           required = false,
                                           defaultValue = "0") int offset,
                                   @RequestParam(value = "limit",
                                           required = false,
                                           defaultValue = "8") int limit);
}
