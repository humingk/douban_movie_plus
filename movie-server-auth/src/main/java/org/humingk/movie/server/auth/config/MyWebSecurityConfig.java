package org.humingk.movie.server.auth.config;

import org.humingk.movie.security.config.WebSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * spring security 安全配置
 *
 * @author humingk
 */
@Configuration
@Order(101)
public class MyWebSecurityConfig extends WebSecurityConfig {
  /**
   * url过滤
   *
   * @param httpSecurity
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf()
        .disable()
        .authorizeRequests()
        // 不需要保护的路径
        .antMatchers("/oauth/**")
        .permitAll()
        // 需要被保护的路径
        .anyRequest()
        .authenticated();
  }
}
