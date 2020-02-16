package org.humingk.movie.api.common.vo.movie.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影经典台词
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassicDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影经典台词ID */
  private Long id;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 经典台词内容 */
  private String content;

  /** 经典台词在影片中的出现时间 /m */
  private Integer happenTime;

  /** 经典台词获得的赞同数 */
  private Integer agreeVote;
}
