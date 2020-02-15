package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.AwardOfMovieDoubanDo;
import org.humingk.movie.dal.entity.MovieDoubanToAwardMovie;
import org.humingk.movie.dal.entity.MovieDoubanToAwardMovieExample;

import java.util.List;

/** @author humingk */
public interface MoviedouanToAwardMovieMapperPlus
    extends BaseMapperPlus<MovieDoubanToAwardMovie, MovieDoubanToAwardMovieExample> {
  /**
   * 通过豆瓣电影ID获取与豆瓣电影相关的获奖信息列表
   *
   * @param idMovieDouban 豆瓣电影ID
   * @return
   */
  List<AwardOfMovieDoubanDo> selectAwardOfMovieListByMovieDoubanId(Long idMovieDouban);
}
