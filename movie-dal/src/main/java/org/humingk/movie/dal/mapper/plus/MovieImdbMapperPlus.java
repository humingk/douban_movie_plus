package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.MovieImdbOfCelebrityImdbDo;
import org.humingk.movie.dal.entity.MovieImdb;
import org.humingk.movie.dal.entity.MovieImdbExample;

import java.util.List;

/** @author humingk */
public interface MovieImdbMapperPlus extends BaseMapperPlus<MovieImdb, MovieImdbExample> {
  /**
   * 通过IMDB影人ID获取与IMDB影人相关的IMDB电影信息列表
   *
   * @param idCelebrityImdb IMDB影人ID
   * @return
   */
  List<MovieImdbOfCelebrityImdbDo> selectMovieImdbOfCelebrityImdbListByCelebrityImdbId(
      Long idCelebrityImdb);
}
