package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.MovieDoubanVo;
import org.humingk.movie.api.common.vo.movie.rate.RateMovieDoubanVo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 电影评分
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateMovieVo implements Serializable {
  /** 豆瓣电影基础信息 */
  private MovieDoubanVo bases;

  /** 豆瓣电影评分 */
  private RateMovieDoubanVo doubanRate;

  /** IMDB电影ID */
  private String idMovieImdb;

  /** IMDB电影链接 */
  private String urlMovieImdb;

  /** IMDB评分 */
  private BigDecimal imdbScore;

  /** IMDB评分人数 */
  private Integer imdbVote;

  /** IMDB评分主题色 */
  private String imdbColor;

  /** 烂番茄新鲜度 */
  private BigDecimal tomatoScore;

  /** 烂番茄新鲜度主题色 */
  private String tomatoColor;

  /** MTC评分 */
  private BigDecimal mtcScore;

  /** MTC评分主题色 */
  private String mtcColor;

  /** 知乎电影ID */
  private Long idMovieZhihu;

  /** 知乎话题链接 */
  private String urlZhihuTopic;

  /** 知乎评分 */
  private BigDecimal zhihuScore;

  /** 知乎评分票数 */
  private Integer zhihuVote;

  /** 知乎推荐度主题色 */
  private String zhihuColor;

  /** 猫眼评分 */
  private BigDecimal maoyanScore;

  /** 猫眼评分主题色 */
  private String maoyanColor;

  private static final long serialVersionUID = 1L;
}
