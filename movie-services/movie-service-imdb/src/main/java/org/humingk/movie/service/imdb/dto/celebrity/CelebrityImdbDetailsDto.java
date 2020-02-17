package org.humingk.movie.service.imdb.dto.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.domain.MovieImdbOfCelebrityImdbDo;

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
public class CelebrityImdbDetailsDto implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB影人基础信息 */
  private CelebrityImdbDto celebrityImdbDto;
  /** 与IMDB影人相关的IMDB电影 */
  private List<MovieImdbOfCelebrityImdbDo> movieImdbOfCelebrityImdbDoList;
}
