package org.humingk.movie.server.auth.config;

import org.humingk.movie.server.auth.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;
import java.util.Map;

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
     * 资源ID
     */
    @Value("${resource.id:spring-boot-application}")
    private String resourceId;

    /**
     * 有效期 s
     */
    private static final int VALIDITY = 7776000;

    /**
     * oauth2 几种模式
     */
    private static final class Modes {
        /**
         * 授权码模式： 第三方应用先申请一个授权码，然后再用该码获取令牌
         * <p>
         * 请求参数:
         * <p>
         * - response_type      授权类型(默认：code)
         * - redirect_uri       重定向URL
         * - client_id          客户端ID
         * - scope              权限范围
         */
        public static final String CODE = "authorization_code";
        /**
         * 简化模式：省略授权码模式中的获取授权码过程
         * <p>
         * 请求参数：
         * <p>
         * - response_type      授权类型(默认：implicit)
         * - redirect_uri       重定向URL
         * - client_id          客户端ID
         * - scope              权限范围
         */
        public static final String IMPLICIT = "implicit";
        /**
         * 密码模式：根据用户名和密码获取授权
         * <p>
         * 请求参数：
         * <p>
         * - grant_type         授权类型(默认：password)
         * - username           用户名
         * - password           密码
         * - scope              权限范围
         */
        public static final String PASSWORD = "password";
        /**
         * 客户端模式: 针对第三方客户端应用的授权
         * <p>
         * 请求参数：
         * <p>
         * - grant_type         授权类型(默认：client_credentials)
         * - client_id          客户端ID
         * - client_secret      客户端密钥
         * - scope              权限范围
         */
        public static final String CLIENT = "client_credentials";
        /**
         * 刷新token: 登录时发送两个令牌，一个用于获取数据，另一个用于更新令牌
         * <p>
         * 请求参数包括：
         * - grant_type         使用的授权模式(默认：refresh_token)
         * - refresh_token      之前收到的更新令牌
         * - scope              权限范围
         */
        public static final String REFRESH = "refresh_token";
    }

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
                .tokenStore(tokenStore)
                // 配置JWT签名秘钥
                .accessTokenConverter(jwtAccessTokenConverter)
                // 配置tokenEnhancerChain
                .tokenEnhancer(tokenEnhancerChain);
    }

    /**
     * 配置第三方客户端
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
//                // 第三方客户端 账号
//                .withClient("client")
//                // 第三方客户端 密码
//                .secret("client")
//                // 第三方客户端在资源服务器的权限：read,write,all
//                .scopes("all")
//                // 此第三方客户端对应的资源ID
////                .resourceIds("movie-server-auth", "movie-server-movie")
//                // 此第三方客户端支持： 密码模式，更新令牌
//                .authorizedGrantTypes(Modes.PASSWORD, Modes.REFRESH)
//                // 通过此第三方登录后的有效期
//                .accessTokenValiditySeconds(VALIDITY)

                // movie-server-movie
                .withClient("movie-server-movie")
                .secret("1233")
                .scopes("all")
                .authorizedGrantTypes(Modes.PASSWORD, Modes.REFRESH)
                .accessTokenValiditySeconds(VALIDITY);
    }

    /**
     * 配置授权以及token的访问权限
     *
     * @param authorizationServerSecurityConfigurer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) {
        authorizationServerSecurityConfigurer
                // 获取秘钥不需要身份认证
                .tokenKeyAccess("permitAll()")
                // 检查秘钥不需要身份认证
                .checkTokenAccess("permitAll()");
    }
}
