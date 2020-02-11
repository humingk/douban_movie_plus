package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐歌手-专辑
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistNeteaseToAlbumNetease implements Serializable {
    /**
     * 网易云音乐歌手ID
     */
    private Long idArtistNetease;

    /**
     * 网易云音乐专辑ID
     */
    private Long idAlbumNetease;

    private static final long serialVersionUID = 1L;
}