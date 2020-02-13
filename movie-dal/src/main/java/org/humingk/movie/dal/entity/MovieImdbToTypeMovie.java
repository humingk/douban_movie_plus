package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * IMDB电影-影片类型
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbToTypeMovie implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB电影ID */
  private Long idMovieImdb;
  /** 影片类型ID */
  private Short idTypeMovie;
}
