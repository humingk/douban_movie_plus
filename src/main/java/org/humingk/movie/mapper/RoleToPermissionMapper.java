package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.RoleToPermission;
import org.humingk.movie.entity.RoleToPermissionExample;

public interface RoleToPermissionMapper {
    long countByExample(RoleToPermissionExample example);

    int deleteByExample(RoleToPermissionExample example);

    int deleteByPrimaryKey(@Param("idRole") Byte idRole, @Param("idPermission") Integer idPermission);

    int insert(RoleToPermission record);

    int insertSelective(RoleToPermission record);

    List<RoleToPermission> selectByExample(RoleToPermissionExample example);

    int updateByExampleSelective(@Param("record") RoleToPermission record, @Param("example") RoleToPermissionExample example);

    int updateByExample(@Param("record") RoleToPermission record, @Param("example") RoleToPermissionExample example);
}