package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 电影别名
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AliasMovieDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影ID */
  private Long idMovieDouban;
  /** 电影别名 */
  private String nameAlias;
}
