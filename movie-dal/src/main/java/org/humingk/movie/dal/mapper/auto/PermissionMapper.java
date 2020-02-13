package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.Permission;
import org.humingk.movie.dal.entity.PermissionExample;

import java.util.List;

@Mapper
public interface PermissionMapper {
  long countByExample(PermissionExample example);

  int deleteByExample(PermissionExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Permission record);

  int insertSelective(Permission record);

  List<Permission> selectByExample(PermissionExample example);

  Permission selectByPrimaryKey(Integer id);

  int updateByExampleSelective(
      @Param("record") Permission record, @Param("example") PermissionExample example);

  int updateByExample(
      @Param("record") Permission record, @Param("example") PermissionExample example);

  int updateByPrimaryKeySelective(Permission record);

  int updateByPrimaryKey(Permission record);
}
