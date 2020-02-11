package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐歌曲-歌单
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongNeteaseToPlaylistNetease implements Serializable {
    /**
     * 网易云音乐歌曲ID
     */
    private Long idSongNetease;

    /**
     * 网易云音乐歌单ID
     */
    private Long idPlaylistNetease;

    /**
     * 歌曲在歌单中的流行度 0-100
     */
    private Byte songPop;

    private static final long serialVersionUID = 1L;
}