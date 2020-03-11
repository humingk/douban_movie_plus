package org.humingk.movie.service.douban.service;

import org.humingk.movie.dal.domain.SearchResultCelebrityDoubanDo;
import org.humingk.movie.dal.domain.SearchTipsCelebrityDoubanDo;
import org.humingk.movie.dal.entity.CelebrityDouban;
import org.humingk.movie.service.douban.dto.CelebrityDoubanDetailsDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/** @author humingk */
@Validated
public interface CelebrityDoubanService {
  /**
   * 获取豆瓣影人基础信息
   *
   * @param id 豆瓣影人ID
   * @return
   */
  @NotNull(message = "此豆瓣影人ID暂无相关豆瓣影人信息")
  CelebrityDouban getCelebrityDoubanByCelebrityDoubanId(long id);

  /**
   * 获取豆瓣影人详细信息
   *
   * @param id 豆瓣影人ID
   * @param limit 相关电影限制数
   * @return
   */
  @NotNull(message = "此豆瓣影人ID暂无相关豆瓣影人信息")
  CelebrityDoubanDetailsDto getCelebrityDoubanDetailsByCelebrityDoubanId(long id, int limit);

  /**
   * 获取豆瓣影人搜索提示列表
   *
   * @param keyword 影人开头关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<SearchTipsCelebrityDoubanDo> getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
      String keyword, int offset, int limit);

  /**
   * 获取豆瓣影人搜索结果列表
   *
   * @param keyword 影人关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<SearchResultCelebrityDoubanDo> getSearchResultCelebrityDoubanListByCelebrityDoubanKeyword(
      String keyword, int offset, int limit);
}
