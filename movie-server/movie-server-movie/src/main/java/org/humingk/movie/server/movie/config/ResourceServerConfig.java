package org.humingk.movie.server.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源访问权限配置
 * <p>
 * 主要用于oauth认证，保护需要token认证的资源
 * <p>
 * EnableResourceServer:    声明为资源服务器
 *
 * @author humingk
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

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
                .authorizeRequests().antMatchers("/test1/**").permitAll()
                // 需要保护的资源路径
                .anyRequest().authenticated();
    }
}
