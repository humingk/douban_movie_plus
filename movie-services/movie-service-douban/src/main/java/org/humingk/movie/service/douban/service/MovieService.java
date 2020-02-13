package org.humingk.movie.service.douban.service;

import org.humingk.movie.dal.entity.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/** @author humingk */
@Validated
public interface MovieService {

  /**
   * 豆瓣电影基础信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该ID暂无对应电影")
  MovieDouban getMovieDoubanByMovieDoubanId(long id);

  /**
   * 豆瓣电影别名列表
   *
   * @param id 豆瓣电影ID
   * @return
   */
  List<AliasMovieDouban> getAliasMovieDoubanListByMovieDoubanId(long id);

  /**
   * 豆瓣电影标签列表
   *
   * @param id 豆瓣电影ID
   * @return
   */
  List<TagMovie> getTagMovieDoubanListByMovieDoubanId(long id);

  /**
   * 豆瓣电影-类型 列表
   *
   * @param id 豆瓣电影ID
   * @return
   */
  List<MovieDoubanToTypeMovie> getMovieDoubanToTypeMovieListByMovieDoubanId(long id);

  /**
   * 豆瓣电影预告片列表
   *
   * @param id 豆瓣电影ID
   * @return
   */
  List<TrailerMovieDouban> getTrailerMovieDoubanListByMovieDoubanId(long id);
}
