package org.humingk.movie.api.common.vo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.details.CelebrityDoubanOfMovieDoubanVo;
import org.humingk.movie.api.common.vo.movie.rate.RateMovieDoubanVo;

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
public class SearchResultMovieDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影基础信息 */
  private MovieDoubanVo base;
  /** 豆瓣电影评分信息 */
  private RateMovieDoubanVo rate;
  /** 豆瓣电影别名列表 */
  private List<String> aliasList;
  /** 豆瓣电影-类型列表 */
  private List<String> typeList;
  /** 豆瓣电影影人列表 */
  private List<CelebrityDoubanOfMovieDoubanVo> celebrityList;
}
