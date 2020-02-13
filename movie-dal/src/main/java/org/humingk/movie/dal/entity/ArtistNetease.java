package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐歌手
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistNetease implements Serializable {
    /**
     * 网易云音乐歌手ID
     */
    private Long id;

    /**
     * 歌手中文名
     */
    private String nameZh;

    /**
     * 歌手照片链接
     */
    private String urlPortrait;

    private static final long serialVersionUID = 1L;
}