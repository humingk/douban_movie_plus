package org.humingk.movie.api.common.vo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.CelebrityDoubanToClassicDouban;
import org.humingk.movie.dal.entity.UserDoubanToClassicDouban;

/**
 * 豆瓣电影经典台词相关
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassicOfMovieDoubanVo {

  /** 豆瓣电影经典台词ID */
  private String id;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 豆瓣电影链接 */
  protected String urlMovieDouban;

  /** 经典台词内容 */
  private String content;

  /** 经典台词在影片中的出现时间 /m */
  private Integer happenTime;

  /** 经典台词获得的赞同数 */
  private Integer agreeVote;

  /** 相关豆瓣用户 */
  private UserDoubanToClassicDouban user;

  /** 相关豆瓣影人 */
  private CelebrityDoubanToClassicDouban celebrity;
}
