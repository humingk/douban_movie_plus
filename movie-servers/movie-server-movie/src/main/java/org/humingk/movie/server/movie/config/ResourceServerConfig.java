package org.humingk.movie.server.movie.config;

import org.humingk.movie.common.exception.MyAccessDeniedHandler;
import org.humingk.movie.common.exception.MyAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

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
//                .authorizeRequests().antMatchers("/test1/**").permitAll()
                .authorizeRequests().antMatchers("/test3/**","/search_movie_tips/**").permitAll()
                // 需要保护的资源路径
                .anyRequest().authenticated();
    }

    @Value("${security.oauth2.resource.jwt.key-value}")
    private String jwtKeyValue;

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(jwtKeyValue);
        accessTokenConverter.setVerifierKey(jwtKeyValue);
        return accessTokenConverter;
    }

    @Autowired
    private TokenStore jwtTokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore);
        // 自定义资源访问异常-未认证
        resources.authenticationEntryPoint(new MyAuthenticationEntryPoint());
        // 自定义资源访问异常-认证失败
        resources.accessDeniedHandler(new MyAccessDeniedHandler());
    }
}
