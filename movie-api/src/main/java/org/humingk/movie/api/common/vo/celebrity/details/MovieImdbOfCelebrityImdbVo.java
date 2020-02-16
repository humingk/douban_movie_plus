package org.humingk.movie.api.common.vo.celebrity.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 与IMDB影人相关的IMDB电影
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbOfCelebrityImdbVo implements Serializable {
  private static final long serialVersionUID = 1L;

  /** IMDB电影ID */
  private String id;

  /** 影片类型ID */
  private Byte idTypeVideo;

  /** 影片类型 */
  private String typeVideo;

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

  /** 该影人在该电影中的职位ID */
  private Byte idProfession;
  /** 该影人在该电影中的职位 */
  private String profession;
}
