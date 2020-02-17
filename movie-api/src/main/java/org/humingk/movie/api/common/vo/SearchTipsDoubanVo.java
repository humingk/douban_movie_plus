package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanVo;
import org.humingk.movie.api.common.vo.movie.SearchTipsMovieDoubanVo;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣搜索提示
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTipsDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影搜索提示列表 */
  private List<SearchTipsMovieDoubanVo> movieList;
  /** 豆瓣影人搜索提示列表 */
  private List<CelebrityDoubanVo> celebrityList;
}
