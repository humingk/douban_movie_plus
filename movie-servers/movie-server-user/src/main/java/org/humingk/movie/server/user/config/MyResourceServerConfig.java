package org.humingk.movie.server.user.config;

import org.humingk.movie.common.exception.MyAccessDeniedHandler;
import org.humingk.movie.common.exception.MyAuthenticationEntryPoint;
import org.humingk.movie.security.config.ResourceServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源访问权限配置
 *
 * @author humingk
 */
@Configuration
public class MyResourceServerConfig extends ResourceServerConfig {

    @Value("${security.oauth2.resource.id}")
    private String resourceId;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;


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
                .authorizeRequests().antMatchers(
                "/test_bus_refresh/**",
                "/*login/**",
                "/github_callback/**",
                "/register/**").permitAll()
                // 需要管理员权限的资源路径
                .antMatchers("/root/**").hasRole("ROOT")
                // 需要保护的资源路径
                .anyRequest().authenticated();
    }

    /**
     * 资源服务器的属性配置
     *
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                // 配置资源服务器ID
                .resourceId(resourceId)
                // 自定义异常
                .accessDeniedHandler(myAccessDeniedHandler)
                .authenticationEntryPoint(myAuthenticationEntryPoint);
    }
}
