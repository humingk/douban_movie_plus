package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.MovieSceneToCelebrityScene;
import org.humingk.common.entity.MovieSceneToCelebritySceneExample;

@Mapper
public interface MovieSceneToCelebritySceneMapper {
    long countByExample(MovieSceneToCelebritySceneExample example);

    int deleteByExample(MovieSceneToCelebritySceneExample example);

    int deleteByPrimaryKey(@Param("idMovieScene") Long idMovieScene, @Param("idCelebrityScene") Long idCelebrityScene);

    int insert(MovieSceneToCelebrityScene record);

    int insertSelective(MovieSceneToCelebrityScene record);

    List<MovieSceneToCelebrityScene> selectByExample(MovieSceneToCelebritySceneExample example);

    int updateByExampleSelective(@Param("record") MovieSceneToCelebrityScene record, @Param("example") MovieSceneToCelebritySceneExample example);

    int updateByExample(@Param("record") MovieSceneToCelebrityScene record, @Param("example") MovieSceneToCelebritySceneExample example);
}