package org.humingk.movie.security.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * security 决策管理器
 * <p>
 * 实现 AccessDecisionManager:
 * <p>
 * 由AbstractSecurityInterceptor调用，负责鉴定用户是否有访问对应资源（方法或URL）的权限
 *
 * @author humingk
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     * 决定用户是否有访问对应受保护对象的权限
     * <p>
     * 没有权限的时候返回AccessDeniedException即可
     *
     * @param authentication   当前的用户信息及权限(UserService中用户登录时加载的权限)
     * @param object           即FilterInvocation对象，request等web资源
     * @param configAttributes 本次访问需要的权限
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 本次访问需要的权限不为空
        if (configAttributes != null && configAttributes.size() > 0) {
            // 循环判断用户权限中是否有本次访问需要的权限
            for (ConfigAttribute configAttribute : configAttributes) {
                for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                    if (configAttribute.getAttribute().trim().equals(grantedAuthority.getAuthority().trim())) {
                        return;
                    }
                }
            }
            // 循环完毕,没有权限
            throw new AccessDeniedException("当前访问没有权限,用户:" + authentication.getName());
        }
    }

    /**
     * 是否能够处理传递的ConfigAttribute的授权请求
     *
     * @param configAttribute 本次访问需要的权限
     * @return true:能
     */
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    /**
     * 是否能够为指定的安全对象（方法调用或Web请求）提供访问控制决策
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
