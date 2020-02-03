package org.humingk.movie.server.auth.config;

import org.humingk.movie.common.entity.Oauth2Modes;
import org.humingk.movie.common.enumeration.Resources;
import org.humingk.movie.common.enumeration.Roles;
import org.humingk.movie.security.config.AuthorizationServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;

/**
 * Oauth2认证授权服务配置
 *
 * @author humingk
 */
@Configuration
public class MyAuthorizationServerConfig extends AuthorizationServerConfig {
    /**
     * 有效期 /s 90d=7776000s
     */
    @Value("${custom.oauth2.validity}")
    private int validity;

    @Value("${custom.oauth2.client.id}")
    private String clientId;

    @Value("${custom.oauth2.client.secret}")
    private String clientSecert;

    @Value("${custom.oauth2.client.scopes}")
    private String clientScopes;

    /**
     * 配置客户端
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientId)
                .secret(new BCryptPasswordEncoder().encode(clientSecert))
                // 支持的角色
                .authorities(Roles.ROOT.name, Roles.USER.name)
                // 支持的资源ID
                .resourceIds(Resources.USER.id, Resources.MOVIE.id, Resources.MUSIC.id)
                .scopes(clientScopes)
                // 支持的请求模式
                .authorizedGrantTypes(Oauth2Modes.PASSWORD, Oauth2Modes.REFRESH)
                .accessTokenValiditySeconds(validity)
                .refreshTokenValiditySeconds(validity);
    }
}
