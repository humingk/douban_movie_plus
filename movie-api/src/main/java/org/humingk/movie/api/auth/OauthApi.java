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
     * @param parameters
     * @return
     */
    @PostMapping("/oauth/token")
    ResponseEntity<Object> postAccessToken(@RequestParam Map<String, String> parameters);
}
