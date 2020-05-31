package org.humingk.movie.api.common.vo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影基础信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影ID */
  protected Long id;

  /** 豆瓣电影链接 */
  protected String urlMovieDouban;
  /** 影片类型ID */
  private Byte idTypeVideo;
  /** 影片类型 */
  private String typeVideo;

  /** IMDB电影ID */
  private String idMovieImdb;

  /** IMDB电影链接 */
  private String urlMovieImdb;

  /** 上映时间 /year */
  private Short startYear;

  /** 豆瓣电影中文名 */
  private String nameZh;

  /** 豆瓣电影原始名 */
  private String nameOrigin;

  /** 豆瓣电影运行片长 /m */
  private Short runtime;

  /** 豆瓣电影海报链接 */
  private String urlPoster;

  /** 已看人数 */
  private Integer haveSeen;

  /** 想看人数 */
  private Integer wannaSee;

  /** 简介 */
  private String summary;
}
