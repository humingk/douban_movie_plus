package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.TypeResource;
import org.humingk.movie.dal.entity.TypeResourceExample;

import java.util.List;

@Mapper
public interface TypeResourceMapper {
  long countByExample(TypeResourceExample example);

  int deleteByExample(TypeResourceExample example);

  int deleteByPrimaryKey(Short id);

  int insert(TypeResource record);

  int insertSelective(TypeResource record);

  List<TypeResource> selectByExample(TypeResourceExample example);

  TypeResource selectByPrimaryKey(Short id);

  int updateByExampleSelective(
      @Param("record") TypeResource record, @Param("example") TypeResourceExample example);

  int updateByExample(
      @Param("record") TypeResource record, @Param("example") TypeResourceExample example);

  int updateByPrimaryKeySelective(TypeResource record);

  int updateByPrimaryKey(TypeResource record);
}
