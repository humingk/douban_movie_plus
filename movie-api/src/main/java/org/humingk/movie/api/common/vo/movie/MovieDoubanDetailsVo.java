package org.humingk.movie.api.common.vo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.details.CelebrityDoubanOfMovieDoubanOv;
import org.humingk.movie.api.common.vo.movie.details.ImageMovieDoubanVo;
import org.humingk.movie.api.common.vo.movie.details.TrailerMovieDoubanVo;
import org.humingk.movie.api.common.vo.movie.rate.RateMovieDoubanVo;
import org.humingk.movie.dal.entity.ClassicDouban;
import org.humingk.movie.dal.entity.CommentMovieDouban;
import org.humingk.movie.dal.entity.MovieDoubanToAwardMovie;
import org.humingk.movie.dal.entity.MovieDoubanToReviewMovieDouban;

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
  /** 豆瓣电影-影人列表 */
  private List<CelebrityDoubanOfMovieDoubanOv> celebrityList;
  /** 豆瓣电影预告片列表 */
  private List<TrailerMovieDoubanVo> trailerList;
  /** 豆瓣电影图片列表 */
  private List<ImageMovieDoubanVo> imageList;
  /** 豆瓣电影经典台词列表 */
  private List<ClassicDouban> classicList;
  /** 豆瓣电影-热门影评列表 */
  private List<MovieDoubanToReviewMovieDouban> movieDoubanToReviewMovieDoubanList;
  /** 豆瓣电影-奖项列表 */
  private List<MovieDoubanToAwardMovie> movieDoubanToAwardMovieList;
  /** 豆瓣电影热门评论列表 */
  private List<CommentMovieDouban> commentMovieDoubanList;
}
