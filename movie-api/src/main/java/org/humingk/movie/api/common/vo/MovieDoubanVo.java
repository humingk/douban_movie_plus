package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDoubanVo implements Serializable {
  /** 豆瓣电影ID */
  protected Long id;

  /** 豆瓣电影链接 */
  protected String urlMovieDouban;

  /** 影片类型 */
  private String typeVideo;

  /** IMDB电影ID 0-未匹配 1-已匹配 */
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

  /** 豆瓣电影海报 */
  private String urlPoster;

  /** 已看人数 */
  private Integer haveSeen;

  /** 想看人数 */
  private Integer wannaSee;

  /** 简介 */
  private String summary;
}
