package org.humingk.movie.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.entity.MovieDoubanToTypeMovie;
import org.humingk.movie.dal.entity.RateMovieDouban;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣电影搜索结果
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultMovieDoubanDo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影基础信息 */
  private MovieDouban movieDouban;
  /** 豆瓣电影评分信息 */
  private RateMovieDouban rateMovieDouban;
  /** 豆瓣电影别名列表 */
  private List<AliasMovieDouban> aliasMovieDoubanList;
  /** 豆瓣电影-类型列表 */
  private List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList;
  /** 豆瓣电影相关影人列表 */
  private List<CelebrityDoubanOfMovieDoubanDo> celebrityDoubanOfMovieDoubanDoList;
}
