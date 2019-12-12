package org.humingk.movie.service;

import org.humingk.movie.entity.Role;
import org.humingk.movie.entity.RoleToPermission;
import org.humingk.movie.entity.User;
import org.humingk.movie.entity.UserToRole;

import java.util.List;

/**
 * 用户接口
 *
 * @author humingk
 */
public interface UserService {
    /**
     * 根据邮箱获取用户信息
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 根据角色ID获取角色
     *
     * @param id
     * @return
     */
    Role getRoleById(int id);

    /**
     * 根据用户ID获取该用户的角色列表
     *
     * @param id
     * @return
     */
    List<Role> getRoleListByUserId(String id);

    /**
     * 根据用户ID获取用户-角色列表
     *
     * @param id
     * @return
     */
    List<UserToRole> getUserToRoleListByUserId(String id);

    /**
     * 根据角色ID获取角色-权限列表
     *
     * @param id
     * @return
     */
    List<RoleToPermission> getRoleToPermission(int id);

}
