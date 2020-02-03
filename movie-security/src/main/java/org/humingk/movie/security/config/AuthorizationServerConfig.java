package org.humingk.movie.security.config;

import org.humingk.movie.common.exception.translator.MyOauth2Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private MyOauth2Translator myOauth2Translator;

    /**
     * 用户详情
     */
    @Autowired
    @Qualifier("myUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Value("${custom.oauth2.key.location}")
    private String keyLocation;

    @Value("${custom.oauth2.key.secret}")
    private String keySecret;

    @Value("${custom.oauth2.key.alias}")
    private String keyAlias;

    /**
     * 注册JWT-存储token
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 注册令牌增强器,增加自定义信息
     *
     * @return
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            Map<String, Object> map = new HashMap() {{
                put("key_1", "value_1");
                put("organization", authentication.getName());
            }};
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
            return accessToken;
        };
    }

    /**
     * 注册令牌转换器,设置非对称加密
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new FileSystemResource(keyLocation), keySecret.toCharArray());
        accessTokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair(keyAlias));
        return accessTokenConverter;
    }

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
                Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter())
        );
        endpoints
                // 配置认证管理器
                .authenticationManager(authenticationManager)
                // 配置userDetailService
                .userDetailsService(userDetailsService)
                // 配置token存储方式
                .tokenStore(tokenStore())
                // 配置tokenEnhancerChain
                .tokenEnhancer(tokenEnhancerChain)
                // 处理/oauth/token的自定义异常
                .exceptionTranslator(myOauth2Translator)
                // 禁止重复使用刷新令牌
                .reuseRefreshTokens(false);
    }

    /**
     * 配置授权服务器的安全信息
     *
     * @param authorizationServerSecurityConfigurer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) {
        authorizationServerSecurityConfigurer
                // 允许表单验证
                .allowFormAuthenticationForClients()
                // 获取秘钥
//                .tokenKeyAccess("isAuthenticated()")
                .tokenKeyAccess("permitAll()")
                // 检查秘钥
//                .checkTokenAccess("isAuthenticated()");
                .checkTokenAccess("permitAll()");
    }
}
