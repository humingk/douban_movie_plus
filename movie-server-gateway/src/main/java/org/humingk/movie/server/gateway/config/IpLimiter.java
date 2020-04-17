package org.humingk.movie.server.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * IP限流配置
 *
 * @author humingk
 */
@Component
public class IpLimiter implements KeyResolver {
  /**
   * 根据请求IP限流
   *
   * @param exchange
   * @return
   */
  @Override
  public Mono<String> resolve(ServerWebExchange exchange) {
    return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
  }
}
