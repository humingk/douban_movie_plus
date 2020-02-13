package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影标签
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagMovie implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影ID */
  private Long idMovieDouban;
  /** 电影标签中文名 */
  private String nameZh;
}
