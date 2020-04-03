package org.humingk.movie.api.common.vo.movie.details;

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
@AllArgsConstructor
@NoArgsConstructor
public class MovieDoubanToCelebrityDoubanVo implements Serializable {
  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 豆瓣影人ID */
  private Long idCelebrityDouban;

  /** 该影人在该电影中的职位ID */
  private Byte idProfession;

  /** 该影人在该电影中的职位 */
  private String profession;

  /** 该影人在该电影中的演员排列顺序 */
  private Short sort;
}
