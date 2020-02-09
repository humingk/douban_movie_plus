package org.humingk.movie.api.auth;

import org.humingk.movie.api.hystrix.auth.Oauth2ApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * auth认证服务器API
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-auth", fallback = Oauth2ApiHystrix.class)
public interface Oauth2Api {
    /**
     * 申请token
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
    @RequestMapping(value = "/oauth/token", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Object> postAccessToken(@RequestBody @NotEmpty Map<String, String> parameters);
}
