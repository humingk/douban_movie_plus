package org.humingk.movie.api.common.vo.movie.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 与IMDB电影相关的IMDB影人
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityImdbOfMovieImdbVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB影人ID */
  private String idCelebrityImdb;

  /** IMDB影人链接 */
  private String urlCelebrityImdb;

  /** 豆瓣影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityDouban;
  /** 豆瓣电影链接 */
  private String urlCelebrityDouban;

  /** IMDB影人英文名 */
  private String nameEn;

  /** 出生年份 /year */
  private Short birthYear;

  /** 该影人与该电影的关系列表 */
  private List<MovieImdbToCelebrityImdbVo> relationList;
}
