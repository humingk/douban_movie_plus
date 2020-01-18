package org.humingk.movie.server.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.common.util.StatusAndMessage;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
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
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().getRawPath();
        // 请求日志
        HashMap<String, Object> logData = new HashMap() {
            {
                put("url", url);
                put("ip", Objects.requireNonNull(request.getRemoteAddress()));
                put("args", request.getQueryParams().toString());
            }
        };
//        // 过滤未带token的api请求
//        if (url.startsWith("/api")) {
//            Object token = request.getHeaders().get("Authorization");
//            if (token == null) {
//                ServerHttpResponse response = exchange.getResponse();
//                response.setStatusCode(HttpStatus.valueOf(StatusAndMessage.UNAUTHORIZED.status));
//                response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
//                logData.put("api_token", "no token");
//                log.info("request,{}", logData);
//                return response.writeWith(
//                        Mono.just(response.bufferFactory().wrap("{\"message\":\"no token\"}".getBytes()))
//                );
//            }
//        }
        log.info("request,{}", logData);
        // 上述为前置过滤
        return chain.filter(exchange);
    }

    /**
     * 此过滤器的优先级别(最高)，值越大优先级越低
     *
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
