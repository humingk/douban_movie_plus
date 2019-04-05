package org.humingk.movie.service.impl;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.humingk.movie.entity.Permission;
import org.humingk.movie.entity.Role;
import org.humingk.movie.entity.User;
import org.humingk.movie.entity.UserRole;
import org.humingk.movie.mapper.*;
import org.humingk.movie.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author humin
 */
@Transactional
@Service
public class ShiroServiceImpl implements ShiroService {

    /**
     * 普通用户名
     */
    private static final String USER = "user";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 根据email获取user
     *
     * @param userEmail
     * @return
     */
    @Override
    public User getUserByUserEmail(String userEmail) {
        return userMapper.selectByUserEmail(userEmail);
    }

    /**
     * 根据userID 获取 roles集合
     *
     * @param userId
     * @return
     */
    @Override
    public List<Role> getRolesByUserId(int userId) {
        return roleMapper.selectByUserId(userId);
    }

    /**
     * 根据roleId 获取 permission集合
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> getPermissionsByRoleId(int roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }

    /**
     * 注册普通用户
     *
     * @param user
     */
    @Override
    public void insertNormalUser(User user) {
        try {
            // 将email作为盐值
            ByteSource salt=ByteSource.Util.bytes(user.getEmail());
            // 加密方式 原密码 盐值 加密次数
            // toHex : 将密码转化为String
            user.setPassword(new SimpleHash(
                    "MD5",user.getPassword(),salt,2).toHex());
            System.out.println("======================================");
            System.out.println(user.getEmail()+"-  - - - - - -  "+user.getPassword());
            userMapper.insert(user);
            int userId = userMapper.selectByUserEmail(user.getEmail()).getUserId();
            int roleId = roleMapper.selectByRoleName(USER).getRoleId();
            userRoleMapper.insert(new UserRole(userId, roleId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
