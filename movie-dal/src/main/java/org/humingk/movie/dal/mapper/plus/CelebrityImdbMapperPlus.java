package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.imdb.CelebrityImdbOfMovieImdbDo;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.dal.entity.CelebrityImdbExample;

import java.util.List;

/** @author humingk */
public interface CelebrityImdbMapperPlus
    extends BaseMapperPlus<CelebrityImdb, CelebrityImdbExample> {
  /**
   * 通过IMDB电影ID获取与IMDB电影相关的IMDB影人信息列表
   *
   * @param idMovieImdb IMDB电影ID
   * @return
   */
  List<CelebrityImdbOfMovieImdbDo> selectCelebrityImdbOfMovieImdbListByMovieImdbId(
      Long idMovieImdb);
}
