package org.humingk.movie.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.entity.Role;
import org.humingk.movie.entity.User;
import org.humingk.movie.entity.UserExample;
import org.humingk.movie.mapper.RoleMapper;
import org.humingk.movie.mapper.UserMapper;
import org.humingk.movie.security.common.SecurityRole;
import org.humingk.movie.security.common.SecurityUser;
import org.humingk.movie.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author humingk
 */
@Slf4j
@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据邮箱获取用户信息
     *
     * @param email
     * @return
     */
    @Override
    public User getUserByEmail(String email) {
        UserExample example = new UserExample();
        example.or().andEmailEqualTo(email);
        return userMapper.selectByExample(example).get(0);
    }

    /**
     * 根据用户ID获取该用户的角色列表
     *
     * @param id
     * @return
     */
    @Override
    public List<Role> getRoleListByUserId(String id) {
        return roleMapper.selectRoleListByUserId(id);
    }

    /**
     * 通过用户登录名(email)获取该用户的用户信息及对应的所有角色名(权限点)
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser = (SecurityUser) getUserByEmail(username);
        if (securityUser != null) {
            List<Role> roleList = getRoleListByUserId(securityUser.getId());
            List<SecurityRole> securityRoleList = Arrays.asList(roleList.toArray(new SecurityRole[0]));
            securityUser.setAuthorities(securityRoleList);
            return securityUser;
        } else {
            log.warn("此用户不存在,{}", username);
            return null;
        }
    }
}
