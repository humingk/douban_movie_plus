package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.douban.CelebrityDoubanOfMovieDoubanDo;
import org.humingk.movie.dal.entity.CelebrityDouban;
import org.humingk.movie.dal.entity.CelebrityDoubanExample;

import java.util.List;

/** @author humingk */
public interface CelebrityDoubanMapperPlus
    extends BaseMapperPlus<CelebrityDouban, CelebrityDoubanExample> {
  /**
   * 通过豆瓣电影ID获取与豆瓣电影相关的豆瓣影人信息列表
   *
   * @param idMovieDouban 豆瓣电影ID
   * @return
   */
  List<CelebrityDoubanOfMovieDoubanDo> selectCelebrityDoubanOfMovieDoubanListByMovieDoubanId(
      Long idMovieDouban);
}
