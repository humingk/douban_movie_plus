package org.humingk.movie.service.imdb.common.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * IMDB电影基础信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbDto implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB电影ID */
  private Long id;

  /** 影片种类 */
  private Byte idTypeVideo;

  /** IMDB电影英文名 */
  private String nameEn;

  /** IMDB电影发行年份 */
  private Short startYear;

  /** 是否是成人电影 0-不是 1-是 */
  private Byte isAdult;

  /** IMDB电影原始名 */
  private String nameOrigin;

  /** IMDB电影片长 /m */
  private Short runtime;

  /** IMDB海报链接 */
  private String urlPoster;

  /** 豆瓣电影ID 0-未匹配 1-已匹配 */
  private Long idMovieDouban;

  /** 简介 */
  private String summary;
}
