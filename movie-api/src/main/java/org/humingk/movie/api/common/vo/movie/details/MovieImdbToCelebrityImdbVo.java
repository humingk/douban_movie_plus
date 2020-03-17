package org.humingk.movie.api.common.vo.movie.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * IMDB电影-影人
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieImdbToCelebrityImdbVo implements Serializable {
  /** IMDB电影ID */
  private Long idMovieImdb;

  /** IMDB影人ID */
  private Long idCelebrityImdb;

  /** 该影人在该电影中的职位ID */
  private Byte idProfession;

  /** 该影人在该电影中的职位 */
  private String profession;
}
