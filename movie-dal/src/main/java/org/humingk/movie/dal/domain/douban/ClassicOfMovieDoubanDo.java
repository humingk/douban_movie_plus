package org.humingk.movie.dal.domain.douban;

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
public class ClassicOfMovieDoubanDo {
  /** 豆瓣电影经典台词ID */
  private String id;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 经典台词内容 */
  private String content;

  /** 经典台词在影片中的出现时间 /m */
  private Integer happenTime;

  /** 经典台词获得的赞同数 */
  private Integer agreeVote;
  /** 豆瓣用户-经典台词 */
  private UserDoubanToClassicDouban userDoubanToClassicDouban;
  /** 豆瓣影人-经典台词 */
  private CelebrityDoubanToClassicDouban celebrityDoubanToClassicDouban;
}
