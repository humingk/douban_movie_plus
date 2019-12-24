package org.humingk.common.security.config;

import lombok.extern.slf4j.Slf4j;
import org.humingk.common.security.filter.JwtTokenFilter;
import org.humingk.common.security.handler.MyAuthenticationFailureHandler;
import org.humingk.common.security.handler.MyAuthenticationSucessHandler;
import org.humingk.common.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 记住我过期时间(秒) 30天
     */
    private static final int TOKEN_VALIDITY_SECONDS = 2419200;

    /**
     * 数据源
     */
    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private MyAuthenticationSucessHandler myAuthenticationSucessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    /**
     * token 持久化
     *
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        /**
         * token表
         *
         * CREATE TABLE persistent_logins (
         *     username VARCHAR (64) NOT NULL,
         *     series VARCHAR (64) PRIMARY KEY,
         *     token VARCHAR (64) NOT NULL,
         *     last_used TIMESTAMP NOT NULL
         * )
         */
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

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
     * 配置Spring security的Filter链
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
     * 配置如何通过拦截器保护请求
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 自定义token过滤器验证请求的token是否合法
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity

                // 用户登录(调用security默认的登录页面)
                .formLogin()
                // 登录页面跳转
//                .loginPage("/login")
                // 登录表单url
                .loginProcessingUrl("/loginForm")
                // 登录成功后执行
                .successHandler(myAuthenticationSucessHandler)
                // 登陆成功后跳转
                .successForwardUrl("/")

                // 登出后跳转登录页面
                .and().logout().logoutSuccessUrl("/login")

                // 记住我
                .and().rememberMe()
                // token持久化
                .tokenRepository(persistentTokenRepository())
                // token过期时间
                .tokenValiditySeconds(TOKEN_VALIDITY_SECONDS)
                // 自动登录逻辑
                .userDetailsService(myUserDetailsService)

                // url过滤
                .and().authorizeRequests()
                // people路径需要token验证才能访问
                .antMatchers("/people/**").authenticated()
                // 其他路径均可访问
                .anyRequest().permitAll()

                // 禁用csrf,登录时不需要_csrf参数
                .and().cors().and().csrf().disable();

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
