package org.humingk.movie.common.controller;

import org.humingk.movie.common.entity.Result;
import org.humingk.movie.common.enumeration.StateAndMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义部分统一错误界面
 *
 * @author humingk
 */
@RestController
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
    public Result error() {
        int status = (int) request.getAttribute("javax.servlet.error.status_code");
        switch (status) {
            case 400:
            case 405:
                return Result.error(StateAndMessage.BADREQUEST);
            case 401:
                return Result.error(StateAndMessage.UNAUTHORIZED);
            case 403:
                return Result.error(StateAndMessage.FORBIDDEN);
            case 404:
                return Result.error(StateAndMessage.NOTFOUND);
            case 500:
                return Result.error(StateAndMessage.ERROR);
            default:
                return Result.error();
        }
    }
}