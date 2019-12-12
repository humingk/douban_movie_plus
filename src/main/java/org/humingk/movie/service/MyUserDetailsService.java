package org.humingk.movie.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 自定义UserDetailsService,注入用户信息和权限
 *
 * @author humingk
 */
public interface MyUserDetailsService extends UserDetailsService {
    /**
     * 通过用户登录名获取该用户所有权限
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
