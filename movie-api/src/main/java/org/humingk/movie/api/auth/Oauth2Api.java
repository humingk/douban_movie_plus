package org.humingk.movie.api.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * auth认证服务器API
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-auth")
public interface Oauth2Api {
  /**
   * 申请token
   *
   * <p>此方法实现位于TokenEndpoint类
   *
   * @param parameters 请求参数: username： 用户名 password： 密码 grant_type： 模式 scope： 权限范围 client_id： 客户端ID
   *     client_secret： 客户端密钥
   * @return
   */
  @RequestMapping(value = "/oauth/token", method = RequestMethod.POST)
  ResponseEntity<Object> postAccessToken(
      @RequestParam("parameters") Map<String, String> parameters);
}
