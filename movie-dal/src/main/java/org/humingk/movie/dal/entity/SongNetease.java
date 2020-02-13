package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 网易云音乐歌曲
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongNetease implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 网易云音乐歌曲ID */
  private Long id;
  /** 歌曲中文名 */
  private String nameZh;
}
