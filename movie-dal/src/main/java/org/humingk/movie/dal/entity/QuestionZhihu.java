package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 知乎问题
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionZhihu implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 知乎问题ID */
  private Long id;
  /** 豆瓣电影ID */
  private Long idMovieDouban;
  /** 知乎问题中文名 */
  private String nameZh;
  /** 回答数 0-默认 1-文章 */
  private Integer answerNum;
}
