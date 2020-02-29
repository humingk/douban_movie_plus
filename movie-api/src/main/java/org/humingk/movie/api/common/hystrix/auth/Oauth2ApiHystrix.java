package org.humingk.movie.api.common.hystrix.auth;

import org.humingk.movie.api.auth.Oauth2Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/** @author humingk */
@Component
public class Oauth2ApiHystrix implements Oauth2Api {
  /**
   * post请求申请token
   *
   * @param parameters 请求参数: username： 用户名 password： 密码 grant_type： 模式 scope： 权限范围 client_id： 客户端ID
   *     client_secret： 客户端密钥
   * @return
   */
  @Override
  public ResponseEntity<Object> postAccessToken(
      @RequestBody @NotEmpty Map<String, String> parameters) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("hystrix");
  }
}
