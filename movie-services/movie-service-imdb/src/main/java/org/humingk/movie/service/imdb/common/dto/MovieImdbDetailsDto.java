package org.humingk.movie.service.imdb.common.dto;

import org.humingk.movie.dal.entity.MovieImdb;
import org.humingk.movie.dal.entity.RateImdb;
import org.humingk.movie.dal.entity.TypeVideo;

/**
 * IMDB电影详细信息
 *
 * @author humingk
 */
public class MovieImdbDetailsDto {
  /** IMDB电影基础信息 */
  private MovieImdb movieImdb;
  /** IMDB电影评分信息（包括烂番茄、MTC） */
  private RateImdb rateImdb;
  /** IMDB电影影片类型 */
  private TypeVideo typeVideo;
}
