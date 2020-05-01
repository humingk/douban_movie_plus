package org.humingk.movie.service.douban.service;

import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.entity.RateMovieDouban;
import org.humingk.movie.service.douban.dto.movie.MovieDoubanDetailsDto;
import org.humingk.movie.service.douban.dto.movie.SearchResultMovieDoubanDto;
import org.humingk.movie.service.douban.dto.movie.SearchTipsMovieDoubanDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

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
  MovieDouban getMovieDoubanByMovieDoubanId(long id);

  /**
   * 豆瓣电影评分信息
   *
   * @param id
   * @return
   */
  @NotNull(message = "该ID暂无对应豆瓣电影")
  RateMovieDouban getRateMovieDoubanByMovieDoubanId(long id);

  /**
   * 豆瓣电影详细信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "该ID暂无对应豆瓣电影")
  MovieDoubanDetailsDto getMovieDoubanDetailsByMovieDoubanId(long id);

  /**
   * 根据电影名称开头的字符串匹配电影的基础信息列表
   *
   * @param keyword 电影开头关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<SearchTipsMovieDoubanDto> getSearchTipsMovieDoubanListByMovieDoubanKeywordStart(
      String keyword, int offset, int limit);

  /**
   * 根据电影名称字符串匹配电影的基础信息列表
   *
   * @param keyword 电影名称关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<SearchResultMovieDoubanDto> getSearchResultMovieDoubanListByMovieDoubanKeyword(
      String keyword, int offset, int limit);
}
