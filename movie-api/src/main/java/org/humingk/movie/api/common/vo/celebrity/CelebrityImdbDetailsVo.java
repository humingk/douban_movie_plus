package org.humingk.movie.api.common.vo.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.celebrity.details.MovieImdbOfCelebrityImdbVo;

import java.io.Serializable;
import java.util.List;

/**
 * IMDB影人详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityImdbDetailsVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB影人基础信息 */
  private CelebrityImdbVo base;
  /** 与IMDB影人相关的IMDB电影 */
  private List<MovieImdbOfCelebrityImdbVo> movieList;
}
