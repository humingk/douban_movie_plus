package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieScene;
import org.humingk.movie.dal.entity.MovieSceneExample;

import java.util.List;

@Mapper
public interface MovieSceneMapper {
  long countByExample(MovieSceneExample example);

  int deleteByExample(MovieSceneExample example);

  int deleteByPrimaryKey(Long id);

  int insert(MovieScene record);

  int insertSelective(MovieScene record);

  List<MovieScene> selectByExample(MovieSceneExample example);

  MovieScene selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") MovieScene record, @Param("example") MovieSceneExample example);

  int updateByExample(
      @Param("record") MovieScene record, @Param("example") MovieSceneExample example);

  int updateByPrimaryKeySelective(MovieScene record);

  int updateByPrimaryKey(MovieScene record);
}
