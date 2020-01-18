package org.humingk.movie.server.gateway.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

/**
 * spring security 安全配置
 *
 * @author humingk
 */
@EnableWebFluxSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 后端网关，url过滤
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and().csrf().disable()
                // 登录页面
                .formLogin()
                // 登陆成功后跳转
                .successForwardUrl("/")
                // 登出后跳转登录页面
                .and().logout().logoutSuccessUrl("/login")
                .and()
                .authorizeRequests()
                // 不需要security保护的路径
                .antMatchers("/api/**","/oauth/**", "/login/**", "/test/**").permitAll()
                // 需要被保护的路径
                .anyRequest().authenticated();
    }


    /**
     * 配置Spring security的Filter链
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) {
        // 用于临时禁用security
//        web.ignoring().antMatchers("/**");
    }
}
