package org.humingk.movie.api.auth;

import org.humingk.movie.api.hystrix.auth.Oauth2ApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * auth认证服务器API
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-auth", fallback = Oauth2ApiHystrix.class)
public interface Oauth2Api {
    /**
     * post请求申请token
     *
     * @param parameters 请求参数:
     *                   username：      用户名
     *                   password：      密码
     *                   grant_type：    模式
     *                   scope：         权限范围
     *                   client_id：     客户端ID
     *                   client_secret： 客户端密钥
     * @return
     */
    @PostMapping("/oauth/token")
    ResponseEntity<Object> postAccessToken(@RequestParam @NotEmpty Map<String, String> parameters);
}
