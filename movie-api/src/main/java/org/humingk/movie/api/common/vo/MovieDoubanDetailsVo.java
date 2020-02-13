package org.humingk.movie.api.common.vo;

import lombok.Data;

import java.util.List;

/**
 * 豆瓣电影详细信息
 *
 * @author humingk
 */
@Data
public class MovieDoubanDetailsVo {
  /** 豆瓣电影别名列表 */
  List<String> aliasList;
  /** 电影类型列表 */
  List<String> typeList;
  /** 电影标签列表 */
  List<String> tagList;
  /** 豆瓣电影预告片列表 */
  List<TrailerMovieDoubanVo> trailerList;
  /** 豆瓣电影基础信息 */
  private MovieDoubanVo baseInfo;
}
