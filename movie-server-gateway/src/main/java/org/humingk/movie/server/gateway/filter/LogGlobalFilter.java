package org.humingk.movie.server.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 *
 * @author humingk
 */
@Slf4j
@Component
public class LogGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getRawPath();
        // gateway拦截所有的请求，统一记录请求日志
        log.info("gateway's request: url={},ip={},args={},method={}",
                request.getURI().getRawPath(),
                request.getRemoteAddress(),
                request.getQueryParams().toString(),
                request.getMethod()
        );
        return chain.filter(exchange);
    }

    /**
     * 此过滤器的优先级别最高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
