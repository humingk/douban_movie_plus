package org.humingk.movie.service.imdb.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.MovieImdb;
import org.humingk.movie.dal.entity.MovieImdbToCelebrityImdb;
import org.humingk.movie.dal.entity.MovieImdbToTypeMovie;
import org.humingk.movie.dal.entity.RateImdb;

import java.io.Serializable;
import java.util.List;

/**
 * IMDB电影详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbDetailsDto implements Serializable {
  /** IMDB电影基础信息 */
  private MovieImdb movieImdb;
  /** IMDB电影评分信息（包括烂番茄、MTC） */
  private RateImdb rateImdb;
  /** IMDB电影-类型列表 */
  private List<MovieImdbToTypeMovie> movieImdbToTypeMovieList;
  /** IMDB电影-影人列表 */
  private List<MovieImdbToCelebrityImdb> movieImdbToCelebrityImdbList;
}
