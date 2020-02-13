package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.Profession;
import org.humingk.movie.dal.entity.ProfessionExample;

import java.util.List;

@Mapper
public interface ProfessionMapper {
  long countByExample(ProfessionExample example);

  int deleteByExample(ProfessionExample example);

  int deleteByPrimaryKey(Byte id);

  int insert(Profession record);

  int insertSelective(Profession record);

  List<Profession> selectByExample(ProfessionExample example);

  Profession selectByPrimaryKey(Byte id);

  int updateByExampleSelective(
      @Param("record") Profession record, @Param("example") ProfessionExample example);

  int updateByExample(
      @Param("record") Profession record, @Param("example") ProfessionExample example);

  int updateByPrimaryKeySelective(Profession record);

  int updateByPrimaryKey(Profession record);
}
