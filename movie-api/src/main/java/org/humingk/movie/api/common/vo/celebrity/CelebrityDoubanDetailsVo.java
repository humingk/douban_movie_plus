package org.humingk.movie.api.common.vo.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.celebrity.details.AliasCelebrityDoubanVo;
import org.humingk.movie.api.common.vo.celebrity.details.MovieDoubanOfCelebrityDoubanVo;
import org.humingk.movie.api.common.vo.share.AwardOfMovieAndCelebrityDoubanVo;
import org.humingk.movie.api.common.vo.share.ImageDoubanVo;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣影人详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDoubanDetailsVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人基础信息 */
  private CelebrityDoubanVo base;
  /** 豆瓣影人别称列表 */
  private List<AliasCelebrityDoubanVo> aliasList;
  /** 豆瓣影人图片列表 */
  private List<ImageDoubanVo> imageList;
  /** 与豆瓣影人相关的豆瓣电影列表 order by score */
  private List<MovieDoubanOfCelebrityDoubanVo> movieListOrderByScore;
  /** 与豆瓣影人相关的豆瓣电影列表 order by start year */
  private List<MovieDoubanOfCelebrityDoubanVo> movieListOrderByStartYear;
  /** 豆瓣影人-电影奖项 */
  private List<AwardOfMovieAndCelebrityDoubanVo> awardList;
}
