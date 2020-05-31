package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.MovieDoubanDetailsVo;
import org.humingk.movie.api.common.vo.movie.MovieImdbDetailsVo;

import java.io.Serializable;

/**
 * 电影详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetailsVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影详细信息 */
  private MovieDoubanDetailsVo douban;
  /** IMDB电影详细信息 */
  private MovieImdbDetailsVo imdb;
}
