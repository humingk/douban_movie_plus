package org.humingk.movie.service.zhihu.service;

import org.humingk.movie.service.zhihu.dto.ZhihuDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 知乎电影相关服务
 *
 * @author humingk
 */
@Validated
public interface ZhihuService {
  /**
   * 获取知乎电影相关
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "此豆瓣电影ID暂无对应知乎话题")
  ZhihuDto getMovieZhihuByMovieDoubanId(Long id);
}
