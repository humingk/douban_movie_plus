package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieSceneToCelebrityScene;
import org.humingk.movie.dal.entity.MovieSceneToCelebritySceneExample;

import java.util.List;

@Mapper
public interface MovieSceneToCelebritySceneMapper {
  long countByExample(MovieSceneToCelebritySceneExample example);

  int deleteByExample(MovieSceneToCelebritySceneExample example);

  int deleteByPrimaryKey(
      @Param("idMovieScene") Long idMovieScene, @Param("idCelebrityScene") Long idCelebrityScene);

  int insert(MovieSceneToCelebrityScene record);

  int insertSelective(MovieSceneToCelebrityScene record);

  List<MovieSceneToCelebrityScene> selectByExample(MovieSceneToCelebritySceneExample example);

  int updateByExampleSelective(
      @Param("record") MovieSceneToCelebrityScene record,
      @Param("example") MovieSceneToCelebritySceneExample example);

  int updateByExample(
      @Param("record") MovieSceneToCelebrityScene record,
      @Param("example") MovieSceneToCelebritySceneExample example);
}
