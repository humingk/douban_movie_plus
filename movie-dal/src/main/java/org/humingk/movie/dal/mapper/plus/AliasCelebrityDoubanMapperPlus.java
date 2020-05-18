package org.humingk.movie.dal.mapper.plus;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.AliasCelebrityDouban;
import org.humingk.movie.dal.entity.AliasCelebrityDoubanExample;

import java.util.List;

/** @author humingk */
public interface AliasCelebrityDoubanMapperPlus
    extends BaseMapperPlus<AliasCelebrityDouban, AliasCelebrityDoubanExample> {
  /**
   * 获取豆瓣影人ID列表
   *
   * @param keyword 别名关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<Long> selectIdCelebrityDoubanListByKeyword(
      @Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);
}
