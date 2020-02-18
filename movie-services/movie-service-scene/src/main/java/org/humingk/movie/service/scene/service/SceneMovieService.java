package org.humingk.movie.service.scene.service;

import org.humingk.movie.service.scene.dto.MovieSceneAllDto;
import org.humingk.movie.service.scene.dto.MovieSceneBriefDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 场景服务
 *
 * @author humingk
 */
@Validated
public interface SceneMovieService {
  /**
   * 获取场景电影简略信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "此豆瓣电影ID暂无对应场景电影")
  MovieSceneBriefDto getMovieSceneBriefByMovieDoubanId(Long id);

  /**
   * 获取场景电影详细信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "此豆瓣电影ID暂无对应场景电影")
  MovieSceneAllDto getMovieSceneAllByMovieDoubanId(Long id);
}
