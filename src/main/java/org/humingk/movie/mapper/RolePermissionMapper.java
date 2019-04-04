package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

    int insert(RolePermission record);

    List<RolePermission> selectAll();
}