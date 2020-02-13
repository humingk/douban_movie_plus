package org.humingk.movie.common.controller;

import org.humingk.movie.common.entity.Result;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
/**
 * 部分错误返回控制器
 *
 * @author humingk
 */
public class MyErrorController implements ErrorController {
  @Autowired private HttpServletRequest request;

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
   * 部分不能被Controller层拦截的异常
   *
   * @return
   */
  @RequestMapping("/error")
  public Result error() {
    int status = (int) request.getAttribute("javax.servlet.error.status_code");
    switch (status) {
      case 400:
      case 405:
        return Result.error(CodeAndMsg.BADREQUEST);
      case 401:
        return Result.error(CodeAndMsg.UNAUTHORIZED);
      case 403:
        return Result.error(CodeAndMsg.FORBIDDEN);
      case 404:
        return Result.error(CodeAndMsg.NOTFOUND);
      case 500:
        return Result.error(CodeAndMsg.ERROR);
      default:
        return Result.error();
    }
  }
}
