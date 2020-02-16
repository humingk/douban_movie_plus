package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.MovieDoubanOfCelebrityDoubanDo;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.entity.MovieDoubanExample;

import java.util.List;

/**
 * 与豆瓣影人相关的豆瓣电影
 *
 * @author humingk
 */
public interface MovieDoubanMapperPlus extends BaseMapperPlus<MovieDouban, MovieDoubanExample> {
  /**
   * 通过豆瓣影人ID获取与豆瓣影人相关的豆瓣电影信息列表
   *
   * @param idCelebrityDouban 豆瓣影人ID
   * @return
   */
  List<MovieDoubanOfCelebrityDoubanDo> selectMovieDoubanOfCelebrityDoubanListByCelebrityDoubanId(
      Long idCelebrityDouban);
}
