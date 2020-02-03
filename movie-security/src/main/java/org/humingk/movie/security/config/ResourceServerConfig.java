package org.humingk.movie.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源访问权限配置
 * <p>
 * 主要用于oauth认证，保护需要token认证的资源
 * <p>
 * EnableResourceServer:    声明为资源服务器
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
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 路径过滤
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // 只能这样？
        httpSecurity.authorizeRequests().anyRequest().authenticated();
    }
}
