package org.humingk.common.security.service;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;

/**
 * 所有用户-权限对应关系
 * <p>
 * 继承FilterInvocationSecurityMetadataSource:
 * <p>
 * 用来从数据库中获取请求与权限的对应关系
 *
 * @author humingk
 */
public interface MyInvocationSecurityMetadataSourceService extends FilterInvocationSecurityMetadataSource {
    /**
     * 当接收到一个http请求时, filterSecurityInterceptor会调用的方法
     * 用于获取资源对应的所有权限
     *
     * @param o 包含url信息的HttpServletRequest实例
     * @return 请求该url所需要的所有权限集合
     * @throws IllegalArgumentException
     */
    @Override
    Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException;

    /**
     * Spring容器启动时自动调用
     * 用于初始化所有请求与权限的对应关系
     *
     * @return
     */
    @Override
    Collection<ConfigAttribute> getAllConfigAttributes();

    /**
     * 该类是否能够为指定的 方法调用/Web请求 提供ConfigAttributes
     *
     * @param aClass
     * @return true:能
     */
    @Override
    boolean supports(Class<?> aClass);
}
