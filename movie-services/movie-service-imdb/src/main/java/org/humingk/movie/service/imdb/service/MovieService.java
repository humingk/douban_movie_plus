package org.humingk.movie.service.imdb.service;

import org.humingk.movie.service.imdb.common.dto.MovieImdbDetailsDto;
import org.humingk.movie.service.imdb.common.dto.MovieImdbDto;
import org.springframework.validation.annotation.Validated;

/**
 * IMDB电影服务
 *
 * @author humingk
 */
@Validated
public interface MovieService {
  /**
   * 获取IMDB电影基础信息
   *
   * @param id IMDB电影ID
   * @return
   */
  MovieImdbDto getMovieImdbByMovieImdbId(long id);

  /**
   * 获取IMDB电影详细信息
   *
   * @param id IMDB电影ID
   * @return
   */
  MovieImdbDetailsDto getMovieImdbDetailsByMovieImdbId(long id);
}
