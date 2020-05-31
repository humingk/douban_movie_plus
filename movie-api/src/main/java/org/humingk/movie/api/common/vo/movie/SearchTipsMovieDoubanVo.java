package org.humingk.movie.api.common.vo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.rate.RateMovieDoubanVo;

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
public class SearchTipsMovieDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影基础信息 */
  private MovieDoubanVo base;
  /** 豆瓣电影评分信息 */
  private RateMovieDoubanVo rate;
  /** 豆瓣电影别名列表 */
  private List<String> aliasList;
}
