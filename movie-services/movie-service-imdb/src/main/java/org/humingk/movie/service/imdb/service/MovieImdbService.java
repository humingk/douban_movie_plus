package org.humingk.movie.service.imdb.service;

import org.humingk.movie.dal.entity.MovieImdb;
import org.humingk.movie.dal.entity.RateImdb;
import org.humingk.movie.service.imdb.dto.movie.MovieImdbDetailsDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * IMDB电影服务
 *
 * @author humingk
 */
@Validated
public interface MovieImdbService {
  /**
   * 获取IMDB电影基础信息
   *
   * @param id IMDB电影ID
   * @return
   */
  @NotNull(message = "该IMDB电影ID暂无对应IMDB电影")
  MovieImdb getMovieImdbByMovieImdbId(long id);

  /**
   * 获取IMDB电影基础信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该豆瓣电影ID暂无对应IMDB电影")
  MovieImdb getMovieImdbByMovieDoubanId(long id);

  /**
   * 获取IMDB电影评分信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该豆瓣电影ID暂无对应IMDB电影")
  RateImdb getRateImdbByMovieDoubanId(long id);

  /**
   * 获取IMDB电影详细信息
   *
   * @param id IMDB电影ID
   * @return
   */
  @NotNull(message = "该豆瓣电影ID暂无对应IMDB电影")
  MovieImdbDetailsDto getMovieImdbDetailsByMovieImdbId(long id);

  /**
   * 获取IMDB电影详细信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该豆瓣电影ID暂无对应IMDB电影")
  MovieImdbDetailsDto getMovieImdbDetailsByMovieDoubanId(long id);

  /**
   * 根据IMDB电影基础信息获取IMDB电影详细信息
   *
   * @param movieImdb IMDB电影基础信息
   * @return
   */
  MovieImdbDetailsDto getMovieImdbDetailsByMovieImdb(MovieImdb movieImdb);
}
