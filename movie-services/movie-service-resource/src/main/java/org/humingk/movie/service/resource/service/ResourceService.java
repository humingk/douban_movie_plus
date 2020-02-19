package org.humingk.movie.service.resource.service;

import org.humingk.movie.service.resource.dto.ResourceMovieDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
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
  @NotEmpty(message = "该豆瓣电影ID暂无相应资源")
  List<ResourceMovieDto> getResourceListByMovieDoubanId(Long id);
}
