package org.humingk.movie.service.imdb.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.domain.CelebrityImdbOfMovieImdbDo;
import org.humingk.movie.dal.entity.MovieImdb;
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
  private static final long serialVersionUID = 1L;
  /** IMDB电影基础信息 */
  private MovieImdb movieImdb;
  /** IMDB电影评分信息（包括烂番茄、MTC） */
  private RateImdb rateImdb;
  /** IMDB电影-类型列表 */
  private List<MovieImdbToTypeMovie> movieImdbToTypeMovieList;
  /** 与IMDB电影相关的IMDB影人列表 */
  private List<CelebrityImdbOfMovieImdbDo> celebrityImdbOfMovieImdbDoList;
}
