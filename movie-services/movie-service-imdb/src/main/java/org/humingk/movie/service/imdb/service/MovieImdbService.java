package org.humingk.movie.service.imdb.service;

import org.humingk.movie.service.imdb.common.dto.movie.MovieImdbDetailsDto;
import org.humingk.movie.service.imdb.common.dto.movie.MovieImdbDto;
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
  MovieImdbDto getMovieImdbByMovieImdbId(long id);

  /**
   * 获取IMDB电影基础信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该IMDB电影ID暂无对应IMDB电影")
  MovieImdbDto getMovieImdbByMovieDoubanId(long id);

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
}
