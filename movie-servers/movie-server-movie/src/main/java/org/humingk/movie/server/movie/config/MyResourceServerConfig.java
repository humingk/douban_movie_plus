package org.humingk.movie.server.movie.config;

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
//                .authorizeRequests().antMatchers("/test1/**").permitAll()
                .authorizeRequests().antMatchers("/test3/**", "/search_movie_tips/**").permitAll()
                // 需要保护的资源路径
                .anyRequest().authenticated();
    }
}
