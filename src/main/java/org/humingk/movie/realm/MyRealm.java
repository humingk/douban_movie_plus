package org.humingk.movie.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.humingk.movie.entity.Permission;
import org.humingk.movie.entity.User;
import org.humingk.movie.service.ShiroService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author humin
 */

@Component
public class MyRealm extends AuthorizingRealm {

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
     *      用户登录时，为用户授予权限和角色
     *      根据账号从数据库获取账号密码进行比较，如果一致则登录成功，否则登录失败
     *
     * Retrieves the AuthorizationInfo for the given principals from the underlying data store.  When returning
     * an instance from this method, you might want to consider using an instance of
     * {@link SimpleAuthorizationInfo SimpleAuthorizationInfo}, as it is suitable in most cases.
     *
     * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see SimpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取user
        User user=(User)principals.getPrimaryPrincipal();
        // 获取urls
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        // 获取urls对应的permissions
        if(user!=null){
            List<Permission> permissionsByUser=shiroService.getPermissionsByUser(user);
            if(permissionsByUser.size()!=0){
                for (int i = 0; i <permissionsByUser.size() ; i++) {
                    info.addStringPermission(permissionsByUser.get(i).getUrl());
                }
            }
            return info;
        }
        return null;
    }

    /**
     * 授权验证:
     *      对用户进行授权验证 与过滤器结合
     *      在登录成功后，根据用户id获取到该用户的权限，并把权限保存在安全管理器之中，
     *   当用户访问的时候，会从管理器中判断该用户是否有权限去访问该url。
     *
     * Retrieves authentication data from an implementation-specific datasource (RDBMS, LDAP, etc) for the given
     * authentication token.
     * <p/>
     * For most datasources, this means just 'pulling' authentication data for an associated subject/user and nothing
     * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
     * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
     * <p/>
     * A {@code null} return value means that no account could be associated with the specified token.
     *
     * @param authenticationToken the authentication token containing the user's principal and credentials.
     * @return an {@link AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws AuthenticationException if there is an error acquiring data or performing
     *                                 realm-specific authentication logic for the specified <tt>token</tt>
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 验证账号密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //此处getUsername对应userEmail
        User user=shiroService.getUserByUserEmail(token.getUsername());
        if(user == null){
            return null;
        }
        // 身份认证验证成功，返回一个AuthenticationInfo实现
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getSimpleName());
        return info;
    }
}
