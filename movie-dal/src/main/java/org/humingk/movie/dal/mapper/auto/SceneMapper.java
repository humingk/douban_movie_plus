package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.Scene;
import org.humingk.movie.dal.entity.SceneExample;

import java.util.List;

@Mapper
public interface SceneMapper {
  long countByExample(SceneExample example);

  int deleteByExample(SceneExample example);

  int deleteByPrimaryKey(Long id);

  int insert(Scene record);

  int insertSelective(Scene record);

  List<Scene> selectByExample(SceneExample example);

  Scene selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") Scene record, @Param("example") SceneExample example);

  int updateByExample(@Param("record") Scene record, @Param("example") SceneExample example);

  int updateByPrimaryKeySelective(Scene record);

  int updateByPrimaryKey(Scene record);
}
