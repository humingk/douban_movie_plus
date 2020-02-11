package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐歌曲
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongNetease implements Serializable {
    /**
     * 网易云音乐歌曲ID
     */
    private Long id;

    /**
     * 歌曲中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}