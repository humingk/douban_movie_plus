package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.entity.ReviewMovieDouban;
import org.humingk.movie.dal.entity.ReviewMovieDoubanExample;

import java.util.List;

/** @author humingk */
public interface ReviewMovieDoubanMapperPlus
    extends BaseMapperPlus<ReviewMovieDouban, ReviewMovieDoubanExample> {
  /**
   * 根据豆瓣电影ID获取热门影评列表
   *
   * @param idMovieDouban 豆瓣电影ID
   * @return
   */
  List<ReviewMovieDouban> selectReviewMovieDoubanListByMovieDoubanId(Long idMovieDouban);
}
