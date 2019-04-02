package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    int insert(UserRole record);

    List<UserRole> selectAll();
}