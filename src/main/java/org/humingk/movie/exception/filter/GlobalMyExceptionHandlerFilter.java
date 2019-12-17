package org.humingk.movie.exception.filter;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.common.ResultResponse;
import org.humingk.movie.exception.MyException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局自定义异常处理类
 * <p>
 * 拦截Filter中抛出的自定义异常
 * <p>
 * order:   优先执行
 *
 * @author humingk
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalMyExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (MyException e) {
            log.warn(String.format("已知异常,%d: {}", e.getStatus()), e.getMessage());
            ResultResponse.error(response, e);
        }
    }
}
