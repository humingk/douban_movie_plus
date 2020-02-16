package org.humingk.movie.api.common.vo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.details.*;
import org.humingk.movie.api.common.vo.movie.rate.RateMovieDoubanVo;
import org.humingk.movie.api.common.vo.share.AwardOfMovieAndCelebrityDoubanVo;
import org.humingk.movie.api.common.vo.share.ImageDoubanVo;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣电影详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDoubanDetailsVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影基础信息 */
  private MovieDoubanVo base;
  /** 豆瓣电影评分信息 */
  private RateMovieDoubanVo rate;
  /** 豆瓣电影别名列表 */
  private List<String> aliasList;
  /** 豆瓣电影-类型列表 */
  private List<String> typeList;
  /** 豆瓣电影标签列表 */
  private List<String> tagList;
  /** 豆瓣电影影人列表 */
  private List<CelebrityDoubanOfMovieDoubanVo> celebrityList;
  /** 豆瓣电影预告片列表 */
  private List<TrailerMovieDoubanVo> trailerList;
  /** 豆瓣电影图片列表 */
  private List<ImageDoubanVo> imageList;
  /** 豆瓣电影经典台词列表 */
  private List<ClassicDoubanVo> classicList;
  /** 豆瓣电影热门影评列表 */
  private List<ReviewMovieDoubanVo> reviewList;
  /** 豆瓣电影奖项列表 */
  private List<AwardOfMovieAndCelebrityDoubanVo> awardList;
  /** 豆瓣电影热门评论列表 */
  private List<CommentMovieDoubanVo> commentList;
}
