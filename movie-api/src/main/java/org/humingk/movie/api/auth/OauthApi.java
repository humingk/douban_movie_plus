//package org.humingk.movie.api.auth;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.security.Principal;
//import java.util.Map;
//
///**
// * auth认证服务器API
// *
// * @author humingk
// */
//@FeignClient("movie-server-movie")
//public interface OauthApi {
//    /**
//     * post请求申请token
//     *
//     * @param principal
//     * @param parameters
//     * @return
//     */
//    @PostMapping("/oauth/token")
//    ResponseEntity<OAuth2AccessToken> postAccessToken(Principal principal, @RequestParam
//            Map<String, String> parameters);
//}
