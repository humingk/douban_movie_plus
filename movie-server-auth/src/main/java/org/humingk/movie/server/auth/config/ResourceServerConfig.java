package org.humingk.movie.server.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * 资源访问权限配置
 * <p>
 * 主要用于oauth认证，保护需要token的资源
 * <p>
 * EnableResourceServer:    声明为资源服务器，定义了Order为3，优先级高于Webconfig
 *
 * @author humingk
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * OAuth2请求匹配器
     */
    private static class oauth2RequestedMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            String authorization = request.getHeader("Authorization");
            //判断来源请求是否包含oauth2授权信息,以下任意一个即可
            return
                    // header的Authorization值以Bearer开头
                    ((authorization != null) && authorization.startsWith("Bearer")) ||
                            // 请求参数中包含access_token参数
                            request.getParameter("access_token") != null;
        }
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .requestMatcher(new oauth2RequestedMatcher())
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated();
    }
}
