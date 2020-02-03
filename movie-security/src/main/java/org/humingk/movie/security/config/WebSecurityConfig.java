package org.humingk.movie.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security 安全配置
 * <p>
 * 主要用于用户登录等
 * <p>
 * EnableWebSecurity:   提供基于web的security,自带order=100，优先级低于ResourcesConfig（order=3）,配置覆盖ResourceConfig
 * <p>
 * EnableGlobalMethodSecurity注解:
 * <p>
 * prePostEnable：   开启PreAuthorize注解，基于表达式限制权限
 * <p>
 * securedEnabled:  开启Secured注解
 * <p>
 * jsr250Enabled：   开启RolesAllowed注解
 *
 * @author humingk
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * url过滤
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
    }

    /**
     * 注册 不可逆的加密工具（spring5之后必须配置加密算法）
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 注册 认证管理器，支持密码模式
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
