package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐专辑
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumNetease implements Serializable {
    /**
     * 网易云音乐专辑ID
     */
    private Long id;

    /**
     * 专辑中文名
     */
    private String nameZh;

    /**
     * 专辑歌曲总数
     */
    private Short total;

    /**
     * 封面照片链接
     */
    private String urlCover;

    private static final long serialVersionUID = 1L;
}