package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐歌手-歌曲
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistNeteaseToSongNetease implements Serializable {
    /**
     * 网易云音乐歌手ID
     */
    private Long idArtistNetease;

    /**
     * 网易云音乐歌曲ID
     */
    private Long idSongNetease;

    private static final long serialVersionUID = 1L;
}