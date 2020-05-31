package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐歌曲-专辑
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongNeteaseToAlbumNetease implements Serializable {
    /**
     * 网易云音乐歌曲ID
     */
    private Long idSongNetease;

    /**
     * 网易云音乐专辑ID
     */
    private Long idAlbumNetease;

    private static final long serialVersionUID = 1L;
}