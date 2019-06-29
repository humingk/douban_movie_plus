package org.humingk.movie.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域请求过滤器
 *
 * @author humingk
 */
public class CorsFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 跨域请求默认不携带cookie,如果要携带cookie，需要设置下边2个响应头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");


        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //设置预检请求的缓存时间, 单位是秒
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin,No-Cache,X-Requested-With,If-Modified-Since," +
                        "Pragma,Last-Modified,Cache-Control,Expires,Content-Type,X-E4M-With,userId,token");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
