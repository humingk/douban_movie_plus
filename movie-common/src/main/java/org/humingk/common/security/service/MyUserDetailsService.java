package org.humingk.common.security.service;

import org.humingk.common.entity.Role;
import org.humingk.common.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * 用户所有角色
 * <p>
 * 自定义UserDetailsService
 *
 * @author humingk
 */
public interface MyUserDetailsService extends UserDetailsService {
    /**
     * 根据邮箱获取用户信息
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 根据用户ID获取该用户的角色列表
     *
     * @param id
     * @return
     */
    List<Role> getRoleListByUserId(String id);

    /**
     * 通过用户登录名(email)获取该用户的用户信息及对应的所有角色名(权限点)
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
