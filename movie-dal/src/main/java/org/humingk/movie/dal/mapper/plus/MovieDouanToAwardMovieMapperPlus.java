package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.AwardOfMovieAndCelebrityDoubanDo;
import org.humingk.movie.dal.entity.MovieDoubanToAwardMovie;
import org.humingk.movie.dal.entity.MovieDoubanToAwardMovieExample;

import java.util.List;

/** @author humingk */
public interface MovieDouanToAwardMovieMapperPlus
    extends BaseMapperPlus<MovieDoubanToAwardMovie, MovieDoubanToAwardMovieExample> {
  /**
   * 通过豆瓣电影ID获取与豆瓣电影相关的获奖信息列表
   *
   * @param idMovieDouban 豆瓣电影ID
   * @return
   */
  List<AwardOfMovieAndCelebrityDoubanDo> selectAwardOfMovieAndCelebrityListByMovieDoubanId(
      Long idMovieDouban);

  /**
   * 通过豆瓣影人ID获取与豆瓣影人相关的获奖信息列表
   *
   * @param idCelebrityDouban 豆瓣影人ID
   * @return
   */
  List<AwardOfMovieAndCelebrityDoubanDo> selectAwardOfMovieAndCelebrityListByCelebrityDoubanId(
      Long idCelebrityDouban);
}
