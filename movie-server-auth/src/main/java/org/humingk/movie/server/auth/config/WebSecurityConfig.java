package org.humingk.movie.server.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security 安全配置
 * <p>
 * 主要用于用户登录等
 * <p>
 * EnableWebSecurity:   提供基于web的security,自带order=100，优先级低于ResourcesConfig（order=3）,配置覆盖ResourceConfig
 * <p>
 * securedEnabled:  支持方法注解
 * <p>
 * prePostEnabled:  使用hasRole()表达式
 *
 * @author humingk
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 此filter chain仅对除api之外的url生效
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                // 不需要保护的路径
                .antMatchers("/user/**", "/oauth/**", "/login/**", "/test/**", "/home/**").permitAll()
                // 需要被保护的路径
                .anyRequest().authenticated();
    }

    /**
     * 注册 不可逆的加密工具（spring5之后必须配置加密算法）
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        // 测试-未加密
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();

//        // 测试-未加密
//        return new BCryptPasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String str) {
//                return str.equals(charSequence.toString());
//            }
//        };

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
