package org.humingk.movie.api.common.vo.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.celebrity.details.AliasCelebrityDoubanVo;
import org.humingk.movie.api.common.vo.celebrity.details.MovieDoubanOfCelebrityDoubanVo;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣影人搜索结果
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultCelebrityDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人基础信息 */
  private CelebrityDoubanVo base;
  /** 豆瓣影人别称列表 */
  private List<AliasCelebrityDoubanVo> aliasList;
  /** 与豆瓣影人相关的豆瓣电影列表 */
  private List<MovieDoubanOfCelebrityDoubanVo> movieList;
}
