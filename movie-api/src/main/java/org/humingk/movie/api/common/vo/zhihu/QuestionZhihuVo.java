package org.humingk.movie.api.common.vo.zhihu;

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
@AllArgsConstructor
@NoArgsConstructor
public class QuestionZhihuVo implements Serializable {
  /** 知乎问题ID */
  private Long id;

  /** 知乎问题链接 */
  private String urlZhihuQuestion;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 豆瓣电影链接 */
  private String urlMovieDouban;

  /** 知乎问题中文名 */
  private String nameZh;

  /** 回答数 0-默认 1-文章 */
  private Integer answerNum;

  private static final long serialVersionUID = 1L;
}
