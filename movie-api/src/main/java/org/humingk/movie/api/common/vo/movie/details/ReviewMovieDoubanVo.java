package org.humingk.movie.api.common.vo.movie.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** @author humingk */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewMovieDoubanVo implements Serializable {
  /** 豆瓣电影影评ID */
  private Long id;

  /** 影评链接 */
  private String urlReview;

  /** 赞同数 */
  private Integer agreeVote;

  /** 反对数 */
  private Integer againstVote;

  /** 影评日期 */
  private String createDatetime;

  /** 影评标题 */
  private String title;

  /** 影评内容 */
  private String content;
}
