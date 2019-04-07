
package org.humingk.movie.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.humingk.movie.entity.Permission;
import org.humingk.movie.entity.Role;
import org.humingk.movie.entity.User;
import org.humingk.movie.service.ShiroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author humin
 */

@Component
public class MyRealm extends AuthorizingRealm {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource(name = "shiroService")
    private ShiroService shiroService;

    public void setShiroService(ShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public ShiroService getShiroService() {
        return shiroService;
    }


    /**
     * 登陆验证:
     * 用户登录时，为用户授予权限和角色
     * 根据账号从数据库获取账号密码进行比较，如果一致则登录成功，否则登录失败
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        try {
            // 获取user
            User user = (User) principals.getPrimaryPrincipal();
            // 获取urls
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            // 获取urls对应的permissions
            if (user != null) {
                // 获取user对应的roles
                List<Role> roles = shiroService.getRolesByUserId(user.getUserId());
                // 获取roles对应的permissions
                for (int i = 0; i < roles.size(); i++) {
                    // 添加role信息
                    info.addRole(roles.get(i).getName());
                    List<Permission> permissions = shiroService.getPermissionsByRoleId(roles.get(i).getRoleId());
                    for (int j = 0; j < permissions.size(); j++) {
                        // 添加permission信息
                        info.addStringPermission(permissions.get(j).getUrl());
                    }
                }
                return info;
            }

            logger.info("登录验证");
            logger.info("user.email:" + user.getEmail());
            logger.info("user.permission:" + info.getStringPermissions());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 授权验证:
     * 对用户进行授权验证 与过滤器结合
     * 在登录成功后，根据用户id获取到该用户的权限，并把权限保存在安全管理器之中，
     * 当用户访问的时候，会从管理器中判断该用户是否有权限去访问该url。
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        try {
            // 验证账号密码
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            //此处getUsername对应userEmail
            User user = shiroService.getUserByUserEmail(token.getUsername());
            if (user == null) {
                ////没有返回登录用户名对应的SimpleAuthenticationInfo对象时
                // 就会在LoginController中抛出UnknownAccountException异常
                return null;
            }
            // 身份认证验证成功，返回一个AuthenticationInfo实现
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    // MD5加密的盐 email
                    ByteSource.Util.bytes(user.getEmail()),
                    this.getClass().getSimpleName());
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}