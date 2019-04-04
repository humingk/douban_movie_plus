package org.humingk.movie.mapper;

import org.humingk.movie.entity.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    /**
     * 根据roleId获取permission列表
     * @param roleId
     * @return
     */
    List<Permission> selectByRoleId(Integer roleId);
}