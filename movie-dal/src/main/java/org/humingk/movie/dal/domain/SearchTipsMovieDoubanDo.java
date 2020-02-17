package org.humingk.movie.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.entity.RateMovieDouban;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣电影搜索提示
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTipsMovieDoubanDo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影基础信息 */
  private MovieDouban movieDouban;
  /** 豆瓣电影评分信息 */
  private RateMovieDouban rateMovieDouban;
  /** 豆瓣电影别名列表 */
  private List<AliasMovieDouban> aliasMovieDoubanList;
}
