package org.humingk.movie.server.auth.config;

import org.humingk.movie.server.auth.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * /oauth/authorize：        验证接口
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
    @Qualifier("jwtTokenStore")
    @Autowired
    private TokenStore tokenStore;

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
     * token配置，包括存储方式（JWT）、用户授权模式（密码模式）
     *
     * @param endpoints
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
                .tokenStore(tokenStore)
                // 配置JWT签名秘钥
                .accessTokenConverter(jwtAccessTokenConverter)
                // 配置tokenEnhancerChain
                .tokenEnhancer(tokenEnhancerChain);
    }

//    /**
//     * 客户端验证配置
//     *
//     * @param clients
//     * @throws Exception
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("client")
//                .scopes("xx")
//                .secret("client")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                .and()
//                .withClient("webapp")
//                .scopes("xx")
//                .authorizedGrantTypes("implicit");
//    }

    /**
     * 单点登录，配置/oauth/token访问权限
     *
     * @param authorizationServerSecurityConfigurer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) {
        authorizationServerSecurityConfigurer
                .tokenKeyAccess("permitAll()")
                // 允许已授权用户访问check token接口
                .checkTokenAccess("isAuthenticated()");
    }
}
