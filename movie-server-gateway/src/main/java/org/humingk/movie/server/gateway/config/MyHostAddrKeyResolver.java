package org.humingk.movie.server.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * IP限流解析器
 *
 * @author humingk
 */
@Component
public class MyHostAddrKeyResolver implements KeyResolver {
  /**
   * Hostname进行限流，用hostAddress判断
   *
   * @param exchange
   * @return
   */
  @Override
  public Mono<String> resolve(ServerWebExchange exchange) {
    return Mono.just(
        Objects.requireNonNull(exchange.getRequest().getRemoteAddress())
            .getAddress()
            .getHostAddress());
  }
}
