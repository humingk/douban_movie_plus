package org.humingk.movie.common.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.humingk.movie.common.exception.serializer.MyOauth2ExceptionSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 自定义Oauth2认证服务器异常，处理/oauth/token路径
 *
 * <p>JsonSerialize: 指定Json序列化方式
 *
 * @author humingk
 */
@JsonSerialize(using = MyOauth2ExceptionSerializer.class)
public class MyOauth2Exception extends OAuth2Exception {

  public MyOauth2Exception(String msg) {
    super(msg);
  }
}
