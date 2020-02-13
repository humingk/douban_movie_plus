package org.humingk.movie.dal.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbToCelebrityImdb implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB电影ID */
  private Long idMovieImdb;
  /** IMDB影人ID */
  private Long idCelebrityImdb;
  /** 该影人在该电影中的职位 */
  private Byte idProfession;
}
