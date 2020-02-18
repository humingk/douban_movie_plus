package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.domain.scene.CelebritySceneOfSceneDetailDo;
import org.humingk.movie.dal.entity.CelebrityScene;
import org.humingk.movie.dal.entity.CelebritySceneExample;

import java.util.List;

/** @author humingk */
public interface CelebritySceneMapperPlus
    extends BaseMapperPlus<CelebrityScene, CelebritySceneExample> {
  /**
   * 通过场景详情ID获取与场景详情相关的场景影人
   *
   * @param idSceneDetail 场景详情ID
   * @return
   */
  List<CelebritySceneOfSceneDetailDo> selectCelebritySceneOfSceneDetailListBySceneDetailId(
      Long idSceneDetail);
}
