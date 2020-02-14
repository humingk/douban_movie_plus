package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.MovieDoubanVo;
import org.humingk.movie.api.common.vo.movie.MovieImdbVo;

import java.io.Serializable;

/**
 * 电影基础信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieVo implements Serializable {

  /** 豆瓣电影基础信息 */
  private MovieDoubanVo douban;

  /** IMDB电影基础信息 */
  private MovieImdbVo imdb;
}
