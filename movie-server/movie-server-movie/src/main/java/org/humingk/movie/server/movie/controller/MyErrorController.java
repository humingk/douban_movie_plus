package org.humingk.movie.server.movie.controller;

import org.humingk.movie.common.entity.Result;
import org.humingk.movie.common.enumeration.StatusAndMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义统一错误界面
 *
 * @author humingk
 */
public class MyErrorController implements ErrorController {
    @Autowired
    private HttpServletRequest request;

    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * 响应/error路径，统一处理将要返回的错误
     *
     * @return
     */
    @RequestMapping("/error")
    public Result<Object> error() {
        int status = (int) request.getAttribute("javax.servlet.error.status_code");
        switch (status) {
            case 400:
            case 405:
                return Result.error(StatusAndMessage.BADREQUEST);
            case 401:
                return Result.error(StatusAndMessage.UNAUTHORIZED);
            case 403:
                return Result.error(StatusAndMessage.FORBIDDEN);
            case 404:
                return Result.error(StatusAndMessage.NOTFOUND);
            default:
                return Result.error();
        }
    }
}
