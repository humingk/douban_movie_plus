package org.humingk.movie.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.MovieImdbToCelebrityImdb;

import java.io.Serializable;

/**
 * 与IMDB影人相关的IMDB电影
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbOfCelebrityImdbDo implements Serializable {
  private static final long serialVersionUID = 1L;

  // movieImdb ------------------------------

  /** IMDB电影ID tt+7 */
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

  // MovieImdbToCelebrityImdb ---------------------

  /** IMDB电影-IMDB影人 */
  private MovieImdbToCelebrityImdb movieImdbToCelebrityImdb;
}
