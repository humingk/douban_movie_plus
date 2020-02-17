package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.celebrity.SearchResultCelebrityDoubanVo;
import org.humingk.movie.api.common.vo.movie.SearchResultMovieDoubanVo;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣搜索结果
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影搜索结果列表 */
  private List<SearchResultMovieDoubanVo> movieList;
  /** 豆瓣影人搜索结果列表 */
  private List<SearchResultCelebrityDoubanVo> celebrityList;
}
