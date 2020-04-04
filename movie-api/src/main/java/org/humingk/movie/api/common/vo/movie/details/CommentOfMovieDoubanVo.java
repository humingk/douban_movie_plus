package org.humingk.movie.api.common.vo.movie.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影短评
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentOfMovieDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 豆瓣用户ID */
  private String idUserDouban;

  /** 豆瓣用户昵称 */
  private String nameUserDouban;

  /** 豆瓣用户链接 */
  private String urlUserDouban;

  /** 投票数 */
  private Short agreeVote;

  /** 短评日期 */
  private String createDate;

  /** 短评内容 */
  private String content;
}
