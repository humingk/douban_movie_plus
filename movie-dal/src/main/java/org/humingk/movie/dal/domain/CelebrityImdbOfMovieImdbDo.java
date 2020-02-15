package org.humingk.movie.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.MovieImdbToCelebrityImdb;

import java.io.Serializable;

/** @author humingk */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityImdbOfMovieImdbDo implements Serializable {
  // CelebrityImdb ---------------------------
  /** IMDB影人ID nm++00xxx(7) */
  private Long id;

  /** IMDB影人英文名 */
  private String nameEn;

  /** 出生年份 /year */
  private Short birthYear;

  /** 豆瓣影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityDouban;

  // MovieImdbToCelebrityImdb ---------------------

  /** IMDB电影-IMDB影人 */
  private MovieImdbToCelebrityImdb movieImdbToCelebrityImdb;
}
