package org.humingk.movie.security.config;

import org.humingk.movie.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security 适配器
 * <p>
 * WebSecurityConfigurerAdapter + EnableWebSecurity :提供基于web的security
 * <p>
 * securedEnabled = true:   支持方法注解
 * <p>
 * prePostEnabled=true:     使用hasRole()表达式
 *
 * @author humingk
 */
@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(myUserDetailsService).passwordEncoder(new PasswordEncoder() {
            /**
             * 密码加密
             *
             * @param charSequence
             * @return
             */
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
//                return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
            }

            /**
             * 密码判断
             *
             * @param charSequence
             * @param str
             * @return
             */
            @Override
            public boolean matches(CharSequence charSequence, String str) {
                return str.equals(charSequence.toString());
//                return str.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
            }
        });
    }

    /**
     * web url 拦截
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 临时禁用security
//        web.ignoring().antMatchers("/**");
    }

    /**
     * httpSecurity url 拦截
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // 禁用csrf,登录时不需要_csrf参数
                .cors().and().csrf().disable()
                // 禁用HttpSession,使用JWT
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // url过滤
                .authorizeRequests()
                // 登录注册路径任何人都能访问
                .antMatchers("/login", "/register").permitAll()
                // people路径需要用户已登录才能访问
//                .antMatchers("/people/**").hasRole("user");
                // people路径需要token验证才能访问
                .antMatchers("/people/**").authenticated();


        // 自定义token过滤器验证请求的token是否合法
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.headers().cacheControl();
    }

    @Bean
    public JwtTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
