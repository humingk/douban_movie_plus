package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.Role;
import org.humingk.movie.dal.entity.RoleExample;

import java.util.List;

@Mapper
public interface RoleMapper {
  long countByExample(RoleExample example);

  int deleteByExample(RoleExample example);

  int deleteByPrimaryKey(Byte id);

  int insert(Role record);

  int insertSelective(Role record);

  List<Role> selectByExample(RoleExample example);

  Role selectByPrimaryKey(Byte id);

  int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

  int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

  int updateByPrimaryKeySelective(Role record);

  int updateByPrimaryKey(Role record);
}
