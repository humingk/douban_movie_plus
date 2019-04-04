package org.humingk.movie.mapper;

import org.humingk.movie.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    Role selectByPrimaryKey(Integer roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    /**
     * 根据userId获取Role列表
     * @param userId
     * @return
     */
    List<Role> selectByUserId(Integer userId);

    /**
     * 根据role的name 获取role
     * @param name
     * @return
     */
    Role selectByRoleName(String name);
}