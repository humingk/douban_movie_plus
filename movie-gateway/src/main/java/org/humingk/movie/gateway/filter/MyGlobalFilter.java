package org.humingk.movie.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Objects;

/**
 * 自定义全局过滤器
 *
 * @author humingk
 */
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 请求日志
        ServerHttpRequest request = exchange.getRequest();
        log.info("request,{}", new HashMap() {
            {
                put("url", request.getURI().getRawPath());
                put("ip", Objects.requireNonNull(request.getRemoteAddress()));
                put("args", request.getQueryParams().toString());
            }
        });
        return chain.filter(exchange);
    }

    /**
     * 此过滤器的优先级别，值越大优先级越低
     *
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
