package org.humingk.movie.service.douban.service;

import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDetailsDto;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDto;
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
  CelebrityDoubanDto getCelebrityDoubanByCelebrityDoubanId(long id);

  /**
   * 获取豆瓣影人详细信息
   *
   * @param id 豆瓣影人ID
   * @return
   */
  @NotNull(message = "此豆瓣影人ID暂无相关豆瓣影人信息")
  CelebrityDoubanDetailsDto getCelebrityDoubanDetailsByCelebrityDoubanId(long id);

  /**
   * 获取豆瓣影人搜索提示列表
   *
   * @param keyword 影人开头关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<CelebrityDoubanDto> getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
      String keyword, int offset, int limit);
}
