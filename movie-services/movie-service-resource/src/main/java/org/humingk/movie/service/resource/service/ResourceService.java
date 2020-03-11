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
}
