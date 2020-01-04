package org.humingk.movie.service.common.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.service.common.common.ResultResponse;
import org.humingk.movie.service.common.common.StatusAndMessage;
import org.humingk.movie.service.common.exception.MyException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录失败后执行
 *
 * @author humingk
 */
@Slf4j
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.warn("用户登录失败,email:{}", httpServletRequest.getAttribute("username"));
        ResultResponse.error(httpServletResponse, new MyException(StatusAndMessage.UNAUTHORIZED));
    }
}
