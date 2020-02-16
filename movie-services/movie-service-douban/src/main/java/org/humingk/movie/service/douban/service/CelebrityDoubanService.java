package org.humingk.movie.service.douban.service;

import org.humingk.movie.service.douban.common.dto.celebrity.CelebrityDoubanDetailsDto;
import org.humingk.movie.service.douban.common.dto.celebrity.CelebrityDoubanDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

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
}
