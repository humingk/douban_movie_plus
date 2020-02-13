package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 网易云音乐歌手
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistNetease implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 网易云音乐歌手ID */
  private Long id;
  /** 歌手中文名 */
  private String nameZh;
  /** 歌手照片链接 */
  private String urlPortrait;
}
