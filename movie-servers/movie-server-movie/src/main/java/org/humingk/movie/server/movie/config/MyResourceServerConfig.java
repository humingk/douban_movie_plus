package org.humingk.movie.server.movie.config;

import org.humingk.movie.security.config.ResourceServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源访问权限配置
 *
 * @author humingk
 */
@RefreshScope
@Configuration
public class MyResourceServerConfig extends ResourceServerConfig {

  @Value("${security.oauth2.resource.id}")
  private String resourceId;

  /**
   * 路径过滤
   *
   * @param httpSecurity
   * @throws Exception
   */
  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf()
        .disable()
        // 不需要保护的资源路径
        .authorizeRequests()
        .antMatchers("/movie/**", "/*swagger*/**")
        .permitAll()
        // 剩下都是需要保护的资源路径
        //                .anyRequest().authenticated();
        .anyRequest()
        .permitAll();
  }

  /**
   * 资源服务器的属性配置
   *
   * @param resources
   */
  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    // 配置资源服务器ID
    resources.resourceId(resourceId);
  }
}
