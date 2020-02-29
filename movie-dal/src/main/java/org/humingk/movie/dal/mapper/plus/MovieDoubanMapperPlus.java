package org.humingk.movie.dal.mapper.plus;

import org.apache.ibatis.annotations.Param;
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
   * @param limit 限制数
   * @param order 排序方式（降序）
   * @return
   */
  List<MovieDoubanOfCelebrityDoubanDo> selectMovieDoubanOfCelebrityDoubanListByCelebrityDoubanId(
      @Param("idCelebrityDouban") Long idCelebrityDouban,
      @Param("limit") Integer limit,
      @Param("order") String order);
}
