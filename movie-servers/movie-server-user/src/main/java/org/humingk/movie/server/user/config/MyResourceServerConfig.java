package org.humingk.movie.server.user.config;

import org.humingk.movie.security.config.ResourceServerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * 资源访问权限配置
 *
 * @author humingk
 */
@Configuration
public class MyResourceServerConfig extends ResourceServerConfig {

    /**
     * 路径过滤
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                // 不需要保护的资源路径
                .authorizeRequests().antMatchers("/test3/**", "/*login/**", "/github_callback/**", "/register/**").permitAll()
                // 需要管理员权限的资源路径
//                .antMatchers("/root/**").hasRole("ROOT")
                // 需要保护的资源路径
                .anyRequest().authenticated();
    }
}
