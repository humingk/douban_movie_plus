package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影-影人
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDoubanToCelebrityDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影ID */
  private Long idMovieDouban;
  /** 豆瓣影人ID */
  private Long idCelebrityDouban;
  /** 该影人在该电影中的职位 */
  private Byte idProfession;
  /** 该影人在该电影中的演员排列顺序 */
  private Short sort;
}
