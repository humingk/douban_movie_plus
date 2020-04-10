package org.humingk.movie.server.auth.config;

import org.humingk.movie.security.config.AuthorizationServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;

import static org.humingk.movie.common.enumeration.Roles.ROOT;
import static org.humingk.movie.common.enumeration.Roles.USER;
import static org.humingk.movie.server.auth.entity.Oauth2Mode.PASSWORD;
import static org.humingk.movie.server.auth.entity.Oauth2Mode.REFRESH;
import static org.humingk.movie.server.auth.entity.ResourceId.*;

/**
 * Oauth2认证授权服务配置
 *
 * @author humingk
 */
@RefreshScope
@Configuration
public class MyAuthorizationServerConfig extends AuthorizationServerConfig {
  /** 有效期 /s 90d=7776000s */
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
    clients
        .inMemory()
        .withClient(clientId)
        .secret(new BCryptPasswordEncoder().encode(clientSecert))
        // 支持的角色
        .authorities(ROOT.name, USER.name)
        // 支持的资源ID
        .resourceIds(USER_ID, MOVIE_ID, MUSIC_ID, CELEBRITY_ID, SEARCH_ID, SCENE_ID)
        .scopes(clientScopes)
        // 支持的请求模式
        .authorizedGrantTypes(PASSWORD, REFRESH)
        .accessTokenValiditySeconds(validity)
        .refreshTokenValiditySeconds(validity);
  }
}
