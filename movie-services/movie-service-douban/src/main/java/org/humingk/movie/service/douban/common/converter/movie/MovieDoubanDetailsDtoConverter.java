package org.humingk.movie.service.douban.common.converter.movie;

import org.humingk.movie.dal.domain.CelebrityDoubanOfMovieDoubanDo;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDetailsDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface MovieDoubanDetailsDtoConverter {
  MovieDoubanDetailsDto to(
      /** 豆瓣电影基础信息 */
      MovieDouban movieDouban,
      /** 豆瓣电影评分信息 */
      RateMovieDouban rateMovieDouban,
      /** 豆瓣电影别名列表 */
      List<AliasMovieDouban> aliasMovieDoubanList,
      /** 豆瓣电影-类型列表 */
      List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList,
      /** 豆瓣电影标签列表 */
      List<TagMovie> tagMovieList,
      /** 豆瓣电影相关影人列表 */
      List<CelebrityDoubanOfMovieDoubanDo> celebrityDoubanOfMovieDoubanDoList,
      /** 豆瓣电影预告片列表 */
      List<TrailerMovieDouban> trailerMovieDoubanList,
      /** 豆瓣电影图片列表 */
      List<ImageMovieDouban> imageMovieDoubanList,
      /** 豆瓣电影经典台词列表 */
      List<ClassicDouban> classicDoubanList,
      /** 豆瓣电影热门评论列表 */
      List<CommentMovieDouban> commentMovieDoubanList,
      /** 豆瓣电影热门影评列表 */
      List<ReviewMovieDouban> reviewMovieDoubanList,
      /** 豆瓣电影-奖项列表 */
      List<MovieDoubanToAwardMovie> movieDoubanToAwardMovieList);
}
