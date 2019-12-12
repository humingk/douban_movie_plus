package org.humingk.movie.service.impl;

import org.humingk.movie.entity.*;
import org.humingk.movie.mapper.*;
import org.humingk.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author humingk
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserToRoleMapper userToRoleMapper;
    @Autowired
    private RoleToPermissionMapper roleToPermissionMapper;

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
     * 根据角色ID获取角色
     *
     * @param id
     * @return
     */
    @Override
    public Role getRoleById(int id) {
        return roleMapper.selectByPrimaryKey((byte) id);
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
     * 根据用户ID获取用户-角色列表
     *
     * @param id
     * @return
     */
    @Override
    public List<UserToRole> getUserToRoleListByUserId(String id) {
        UserToRoleExample example = new UserToRoleExample();
        example.or().andIdUserEqualTo(id);
        return userToRoleMapper.selectByExample(example);
    }

    /**
     * 根据角色ID获取角色-权限列表
     *
     * @param id
     * @return
     */
    @Override
    public List<RoleToPermission> getRoleToPermission(int id) {
        RoleToPermissionExample example = new RoleToPermissionExample();
        example.or().andIdRoleEqualTo((byte) id);
        return roleToPermissionMapper.selectByExample(example);
    }
}
