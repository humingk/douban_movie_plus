package org.humingk.common.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.humingk.common.entity.Role;
import org.humingk.common.entity.User;
import org.humingk.common.entity.UserExample;
import org.humingk.common.exception.MyException;
import org.humingk.common.mapper.RoleMapper;
import org.humingk.common.mapper.UserMapper;
import org.humingk.common.security.common.SecurityRole;
import org.humingk.common.security.common.SecurityUser;
import org.humingk.common.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.humingk.common.common.StatusAndMessage.NOUSER;

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
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size() == 1) {
            return userList.get(0);
        } else if (userList.size() == 0) {
            log.warn("无此用户,email:{}", email);
            throw new MyException(NOUSER, email);
        } else {
            throw new MyException();
        }
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
        User user = getUserByEmail(username);
        List<Role> roleList = getRoleListByUserId(user.getId());
        if (roleList.size() == 0) {
            throw new MyException();
        }
        List<SecurityRole> securityRoleList = new ArrayList<>();
        for (Role role : roleList) {
            securityRoleList.add(new SecurityRole(role));
        }
        return new SecurityUser(user, securityRoleList);
    }
}
