package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ContinentScene;
import org.humingk.movie.dal.entity.ContinentSceneExample;

import java.util.List;

@Mapper
public interface ContinentSceneMapper {
  long countByExample(ContinentSceneExample example);

  int deleteByExample(ContinentSceneExample example);

  int deleteByPrimaryKey(Byte id);

  int insert(ContinentScene record);

  int insertSelective(ContinentScene record);

  List<ContinentScene> selectByExample(ContinentSceneExample example);

  ContinentScene selectByPrimaryKey(Byte id);

  int updateByExampleSelective(
      @Param("record") ContinentScene record, @Param("example") ContinentSceneExample example);

  int updateByExample(
      @Param("record") ContinentScene record, @Param("example") ContinentSceneExample example);

  int updateByPrimaryKeySelective(ContinentScene record);

  int updateByPrimaryKey(ContinentScene record);
}
