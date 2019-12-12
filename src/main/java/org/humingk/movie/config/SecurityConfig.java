package org.humingk.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * spring security 配置类
 *
 * securedEnabled = true:   支持方法注解
 * prePostEnabled=true:     使用hasRole()表达式
 *
 * @author humingk
 */
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SecurityConfig {
    /**
     * TokenBasedRememberMeServices生成密钥
     */
    private final String SECRET_KEY = "123456";

}
