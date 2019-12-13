package org.humingk.movie.config.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * security 决策器
 *
 * AccessDecisionManager:
 * 由AbstractSecurityInterceptor调用，负责鉴定用户是否有访问对应资源（方法或URL）的权限
 *
 * @author humingk
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     * 决定用户是否有访问对应受保护对象的权限
     *
     * @param authentication   当前的用户信息及权限
     *                         权限,UserDetailsService中加载的authorities
     * @param object           FilterInvocation对象，可以得到request等web资源
     * @param configAttributes 本次访问需要的权限
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes != null && configAttributes.size() > 0) {
            for (ConfigAttribute configAttribute : configAttributes) {
                for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                    if (configAttribute.getAttribute().trim().equals(grantedAuthority.getAuthority().trim())) {
                        return;
                    }
                }
            }
            throw new AccessDeniedException("当前访问没有权限");
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
