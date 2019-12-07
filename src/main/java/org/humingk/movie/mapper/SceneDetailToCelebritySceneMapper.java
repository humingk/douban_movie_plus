package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.SceneDetailToCelebrityScene;
import org.humingk.movie.entity.SceneDetailToCelebritySceneExample;

public interface SceneDetailToCelebritySceneMapper {
    long countByExample(SceneDetailToCelebritySceneExample example);

    int deleteByExample(SceneDetailToCelebritySceneExample example);

    int deleteByPrimaryKey(@Param("idSceneDetail") Long idSceneDetail, @Param("idCelebrityScene") Long idCelebrityScene);

    int insert(SceneDetailToCelebrityScene record);

    int insertSelective(SceneDetailToCelebrityScene record);

    List<SceneDetailToCelebrityScene> selectByExample(SceneDetailToCelebritySceneExample example);

    int updateByExampleSelective(@Param("record") SceneDetailToCelebrityScene record, @Param("example") SceneDetailToCelebritySceneExample example);

    int updateByExample(@Param("record") SceneDetailToCelebrityScene record, @Param("example") SceneDetailToCelebritySceneExample example);
}