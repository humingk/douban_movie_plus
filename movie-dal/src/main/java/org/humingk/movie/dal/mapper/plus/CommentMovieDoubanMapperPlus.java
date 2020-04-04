package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.douban.CommentOfMovieDoubanDo;
import org.humingk.movie.dal.entity.CommentMovieDouban;
import org.humingk.movie.dal.entity.CommentMovieDoubanExample;

import java.util.List;

/**
 * 豆瓣电影评论
 *
 * @author humingk
 */
public interface CommentMovieDoubanMapperPlus
    extends BaseMapperPlus<CommentMovieDouban, CommentMovieDoubanExample> {
  /**
   * 通过豆瓣电影ID获取豆瓣评论以及豆瓣用户
   *
   * @param idMovieDouban
   * @return
   */
  List<CommentOfMovieDoubanDo> selectCommentOfMovieDoubanListByMovieDoubanId(Long idMovieDouban);
}
