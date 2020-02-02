package org.humingk.movie.security.config;

import org.humingk.movie.service.user.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

/**
 * Oauth2认证授权服务配置
 * <p>
 * EnableAuthorizationServer:   声明为认证服务器,支持请求包括：
 * <p>
 * /oauth/authorize：        授权码模式认证授权接口
 * <p>
 * /oauth/token：            获取token
 * <p>
 * /oauth/confirm_access：   用户授权
 * <p>
 * /oauth/error：            认证失败
 * <p>
 * /oauth/check_token：      资源服务器用来校验token
 * <p>
 * /oauth/token_key：        jwt模式下获取公钥
 *
 * @author humingk
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    /**
     * 认证管理器
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 用户详情
     */
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    /**
     * 存储token (JWT)
     * <p>
     * 可选：
     * <p>
     * -JWT:    JwtTokenStoreConfig.java
     * <p>
     * -Redis:
     * <p>
     * -MySQL:
     */
    @Autowired
    private TokenStore jwtTokenStore;

    /**
     * JWT-签名设置秘钥
     */
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    /**
     * JWT-自定义JWT
     */
    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;


    /**
     * 配置端点安全约束，包括存储方式（JWT）、用户授权模式（密码模式）
     *
     * @param endpoints 端点接入
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // tokenEnhancerChain 配置
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
                Arrays.asList(
                        // 自定义JWT
                        jwtTokenEnhancer,
                        // JWT签名秘钥
                        jwtAccessTokenConverter
                )
        );
        endpoints
                // 配置认证管理器
                .authenticationManager(authenticationManager)
                // 配置用户验证
                .userDetailsService(myUserDetailsService)
                // 配置token存储方式
                .tokenStore(jwtTokenStore)
                // 配置JWT签名秘钥
                .accessTokenConverter(jwtAccessTokenConverter)
                // 配置tokenEnhancerChain
                .tokenEnhancer(tokenEnhancerChain);
    }

    /**
     * 配置授权以及token的访问权限
     *
     * @param authorizationServerSecurityConfigurer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) {
        authorizationServerSecurityConfigurer
                // 允许表单验证
                .allowFormAuthenticationForClients()
                // 允许非认证用户获取秘钥
                .tokenKeyAccess("permitAll()")
                // 允许非认证用户检查秘钥
                .checkTokenAccess("permitAll()");
    }
}
