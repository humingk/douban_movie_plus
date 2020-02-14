package org.humingk.movie.api.common.vo.movie.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影中的豆瓣影人
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDoubanOfMovieDoubanOv implements Serializable {
  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 豆瓣影人ID */
  private Long idCelebrityDouban;

  /** 职位 */
  private String profession;

  /** 排列顺序 */
  private Short sort;
}
