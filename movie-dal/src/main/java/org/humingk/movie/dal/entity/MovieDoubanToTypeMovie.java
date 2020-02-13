package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影-电影类型
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDoubanToTypeMovie implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影ID */
  private Long idMovieDouban;
  /** 影片类型ID */
  private Short idTypeMovie;
}
