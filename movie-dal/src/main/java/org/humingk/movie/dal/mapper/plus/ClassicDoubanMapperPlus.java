package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.douban.ClassicOfMovieDoubanDo;
import org.humingk.movie.dal.entity.ClassicDouban;
import org.humingk.movie.dal.entity.ClassicDoubanExample;

import java.util.List;

/** @author humingk */
public interface ClassicDoubanMapperPlus
    extends BaseMapperPlus<ClassicDouban, ClassicDoubanExample> {
  /**
   * 根据豆瓣电影ID获取经典台词相关
   *
   * @param idMovieDouban 豆瓣电影ID
   * @return
   */
  List<ClassicOfMovieDoubanDo> selectClassicOfMovieDoubanDoListByMovieDoubanId(Long idMovieDouban);
}
