package org.humingk.movie.service.resource.service;

import org.humingk.movie.dal.entity.ResourceMovie;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 电影资源服务
 *
 * @author humingk
 */
@Validated
public interface ResourceService {
  /**
   * 获取电影资源
   *
   * @param id 豆瓣电影ID
   * @return
   */
  List<ResourceMovie> getResourceListByMovieDoubanId(Long id);

  /**
   * 搜索电影资源
   *
   * @param keyword 电影关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<ResourceMovie> getResourceListByKeyword(String keyword, int offset, int limit);
}
