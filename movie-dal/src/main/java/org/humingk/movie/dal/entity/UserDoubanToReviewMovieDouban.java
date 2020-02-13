package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣用户-豆瓣影评
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDoubanToReviewMovieDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣用户ID */
  private String idUserDouban;
  /** 豆瓣影评ID */
  private Long idReviewMovieDouban;
}
