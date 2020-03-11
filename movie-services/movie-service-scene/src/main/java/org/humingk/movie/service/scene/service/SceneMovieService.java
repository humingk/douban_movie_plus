package org.humingk.movie.service.scene.service;

import org.humingk.movie.dal.entity.MovieScene;
import org.humingk.movie.dal.entity.Scene;
import org.humingk.movie.service.scene.dto.MovieSceneAllDto;
import org.humingk.movie.service.scene.dto.MovieSceneBriefDto;
import org.humingk.movie.service.scene.dto.MovieSceneDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 场景电影服务
 *
 * @author humingk
 */
@Validated
public interface SceneMovieService {
  /**
   * 获取场景电影信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  MovieScene getMovieSceneByMovieDoubanId(Long id);

  /**
   * 获取场景列表
   *
   * @param id 场景电影ID
   * @return
   */
  List<Scene> getSceneListByMovieSceneId(Long id);

  /**
   * 获取场景电影简略信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  MovieSceneBriefDto getMovieSceneBriefByMovieDoubanId(Long id);

  /**
   * 获取场景电影详细信息
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @NotNull(message = "此豆瓣电影ID暂无对应场景电影")
  MovieSceneAllDto getMovieSceneAllByMovieDoubanId(Long id);

  /**
   * 通过关键字开头获取场景电影列表
   *
   * @param keyword 电影名称关键字
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<MovieSceneDto> getMovieSceneListByMovieSceneKeywordStart(
      String keyword, int offset, int limit);
}
