package org.humingk.movie.server.auth.config;

import org.humingk.movie.security.config.AuthorizationServerConfig;
import org.humingk.movie.security.entity.OauthModes;
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
     * 配置第三方客户端
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 用于password认证的客户端
                .withClient(clientId)
                .secret(new BCryptPasswordEncoder().encode(clientSecert))
                .authorities("ROLE_USER", "ROLE_ROOT")
                .scopes(clientScopes)
                .authorizedGrantTypes(OauthModes.PASSWORD, OauthModes.REFRESH)
                .accessTokenValiditySeconds(validity);
    }
}
