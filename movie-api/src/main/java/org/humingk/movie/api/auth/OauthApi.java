package org.humingk.movie.api.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * auth认证服务器API
 *
 * @author humingk
 */
@FeignClient("movie-server-auth")
public interface OauthApi {
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
    ResponseEntity<Object> postAccessToken(@RequestParam Map<String, String> parameters);
}
