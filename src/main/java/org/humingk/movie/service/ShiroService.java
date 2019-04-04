package org.humingk.movie.service;

import org.humingk.movie.entity.Permission;
import org.humingk.movie.entity.Role;
import org.humingk.movie.entity.User;

import java.util.List;

public interface ShiroService {

    /**
     * 根据email获取user
     * @param userEmail
     * @return
     */
    User getUserByUserEmail(String userEmail);


    /**
     *  根据userID 获取 roles集合
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(int userId);

    /**
     * 根据roleId 获取 permission集合
     * @param roleId
     * @return
     */
    List<Permission> getPermissionsByRoleId(int roleId);

    /**
     * 注册普通用户
     * @param user
     */
    void insertNormalUser(User user);

}
