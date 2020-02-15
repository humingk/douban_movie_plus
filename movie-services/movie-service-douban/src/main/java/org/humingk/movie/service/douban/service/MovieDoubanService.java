package org.humingk.movie.service.douban.service;

import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDetailsDto;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 豆瓣电影服务
 *
 * @author humingk
 */
@Validated
public interface MovieDoubanService {

  /**
   * 豆瓣电影基础信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该ID暂无对应豆瓣电影")
  MovieDoubanDto getMovieDoubanByMovieDoubanId(long id);

  /**
   * 豆瓣电影详细信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该ID暂无对应豆瓣电影")
  MovieDoubanDetailsDto getMovieDoubanDetailsByMovieDoubanId(long id);
}
