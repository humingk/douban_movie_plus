package org.humingk.movie.api.common.vo.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.movie.details.CelebrityImdbOfMovieImdbVo;
import org.humingk.movie.api.common.vo.movie.rate.RateMovieImdbVo;

import java.io.Serializable;
import java.util.List;

/**
 * IMDB电影详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbDetailsVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB电影基础信息 */
  private MovieImdbVo base;
  /** IMDB电影评分 */
  private RateMovieImdbVo rate;
  /** IMDB电影类型列表 */
  private List<String> typeList;
  /** IMDB电影影人列表 */
  private List<CelebrityImdbOfMovieImdbVo> celebrityList;
}
