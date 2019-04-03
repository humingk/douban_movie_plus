package org.humingk.movie.service.impl;

import org.humingk.movie.entity.Permission;
import org.humingk.movie.entity.Role;
import org.humingk.movie.entity.User;
import org.humingk.movie.mapper.PermissionMapper;
import org.humingk.movie.mapper.RoleMapper;
import org.humingk.movie.mapper.UserMapper;
import org.humingk.movie.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humin
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private RoleMapper roleMapper;
    @Autowired(required = false)
    private PermissionMapper permissionMapper;

    /**
     * 根据email获取user
     *
     * @param userEmail
     * @return
     */
    @Override
    public User getUserByUserEmail(String userEmail) {
        User user=userMapper.selectByUserEmail(userEmail);
        return user;
    }

    /**
     * 根据user获取该账号的权限
     *
     * @param user
     * @return
     */
    @Override
    public List<Permission> getPermissionsByUser(User user) {

        // 获取该user所有的role
        List<Role> roles=roleMapper.selectByUserId(user.getUserId());

        // 获取所有的user对应的permission
        List<Permission> permissions=new ArrayList<Permission>();
        if(roles!=null && roles.size()!=0){
            for (int i = 0; i <roles.size() ; i++) {
                if(roles.get(i).getRoleId()!=null){
                    permissions.addAll(permissionMapper.selectByRoleId(roles.get(i).getRoleId()));
                }
            }
        }
        return permissions;
    }
}
