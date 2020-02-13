package org.humingk.movie.service.douban.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.*;

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
public class MovieDoubanDetailsDto implements Serializable {
  /** 豆瓣电影基础信息 */
  private MovieDoubanDto movieDoubanDto;
  /** 豆瓣电影评分信息 */
  private RateMovieDouban rateMovieDouban;
  /** 豆瓣电影别名列表 */
  private List<AliasMovieDouban> aliasMovieDoubanList;
  /** 豆瓣电影-类型列表 */
  private List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList;
  /** 豆瓣电影标签列表 */
  private List<TagMovie> tagMovieList;
  /** 豆瓣电影-影人列表 */
  private List<MovieDoubanToCelebrityDouban> movieDoubanToCelebrityDoubanList;
  /** 豆瓣电影预告片列表 */
  private List<TrailerMovieDouban> trailerMovieDoubanList;
  /** 豆瓣电影图片列表 */
  private List<ImageMovieDouban> imageMovieDoubanList;
  /** 豆瓣电影经典台词列表 */
  private List<ClassicDouban> classicDoubanList;
  /** 豆瓣电影热门评论列表 */
  private List<CommentMovieDouban> commentMovieDoubanList;
  /** 豆瓣电影-热门影评列表 */
  private List<MovieDoubanToReviewMovieDouban> movieDoubanToReviewMovieDoubanList;
  /** 豆瓣电影-奖项列表 */
  private List<MovieDoubanToAwardMovie> movieDoubanToAwardMovieList;
}
