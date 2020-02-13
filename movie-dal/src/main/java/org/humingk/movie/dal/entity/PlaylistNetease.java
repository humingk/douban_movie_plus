package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐歌单
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistNetease implements Serializable {
    /**
     * 网易云音乐歌单ID
     */
    private Long id;

    /**
     * 歌单中文名
     */
    private String nameZh;

    /**
     * 歌单歌曲总数
     */
    private Short total;

    /**
     * 歌单播放次数
     */
    private Integer playCount;

    /**
     * 封面照片链接
     */
    private String urlCover;

    /**
     * 歌单描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}