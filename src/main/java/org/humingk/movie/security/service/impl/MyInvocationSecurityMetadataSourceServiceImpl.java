package org.humingk.movie.security.service.impl;

import org.humingk.movie.entity.*;
import org.humingk.movie.mapper.PermissionMapper;
import org.humingk.movie.mapper.RoleMapper;
import org.humingk.movie.mapper.RoleToPermissionMapper;
import org.humingk.movie.security.service.MyInvocationSecurityMetadataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * 所有用户-权限对应关系
 *
 * @author humingk
 */
@Service
public class MyInvocationSecurityMetadataSourceServiceImpl implements MyInvocationSecurityMetadataSourceService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleToPermissionMapper roleToPermissionMapper;

    /**
     * 每一个url请求所对应的角色
     */
    private static HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 用于获取资源对应的所有权限
     * <p>
     * 当接收到一个http请求时, filterSecurityInterceptor调用此方法且注入所有用户-权限关系
     *
     * @param object 包含url信息的HttpServletRequest实例
     * @return 请求该url所需要的所有权限集合
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        for (String url : map.keySet()) {
            // 匹配返回url需要的权限
            if (new AntPathRequestMatcher(url).matches(request)) {
                return map.get(url);
            }
        }
        return null;
    }

    /**
     * Spring容器启动时自动调用
     * 用于初始化所有请求与权限的对应关系
     *
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        loadAllConfigAttributes();
        return null;
    }

    /**
     * 该类是否能够为指定的 方法调用/Web请求 提供ConfigAttributes
     *
     * @param aClass
     * @return true:能
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化map
     */
    public void loadAllConfigAttributes() {
        // map初始化
        if (map == null) {
            // 所有的角色
            RoleExample roleExample = new RoleExample();
            roleExample.or();
            List<Role> roleList = roleMapper.selectByExample(roleExample);

            // 所有的权限
            PermissionExample permissionExample = new PermissionExample();
            permissionExample.or();
            List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

            // 所有的角色-权限关系
            RoleToPermissionExample roleToPermissionExample = new RoleToPermissionExample();
            roleToPermissionExample.or();
            List<RoleToPermission> roleToPermissionList = roleToPermissionMapper.selectByExample(roleToPermissionExample);

            map = new HashMap<>(16);
            for (Permission permission : permissionList) {
                map.put(permission.getPathSrc(), new ArrayList<>());
                for (RoleToPermission roleToPermission : roleToPermissionList) {
                    // 每个权限路径对应多个角色
                    if (permission.getId().equals(roleToPermission.getIdPermission())) {
                        for (Role role : roleList) {
                            // 角色ID对应的角色
                            if (role.getId().equals(roleToPermission.getIdRole())) {
                                ConfigAttribute configAttribute = new SecurityConfig(role.getNameZh());
                                // 增加权限对应的角色列表
                                map.get(permission.getPathSrc()).add(configAttribute);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
