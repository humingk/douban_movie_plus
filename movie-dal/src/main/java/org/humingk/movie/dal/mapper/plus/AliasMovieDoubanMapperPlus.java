package org.humingk.movie.dal.mapper.plus;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.humingk.movie.dal.entity.AliasMovieDoubanExample;

import java.util.List;

/** @author humingk */
public interface AliasMovieDoubanMapperPlus
    extends BaseMapperPlus<AliasMovieDouban, AliasMovieDoubanExample> {
  /**
   * 获取豆瓣电影ID列表
   *
   * @param keyword 别名关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<Long> selectIdMovieDoubanListByKeyword(
      @Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);
}
