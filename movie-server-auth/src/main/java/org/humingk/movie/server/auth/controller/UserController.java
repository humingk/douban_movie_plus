package org.humingk.movie.server.auth.controller;

import org.humingk.movie.common.entity.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户
 *
 * @author humingk
 */
@RestController
public class UserController {
    @GetMapping("/api/test")
    public String api() {
        return "test api(need token authorized)";
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        System.out.println();
        return principal;
    }

//    @GetMapping("/user")
//    public Result user(Principal principal) {
////        return user;
//        if (principal != null) {
//            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
//            Authentication authentication = oAuth2Authentication.getUserAuthentication();
//            Map<String, String> details = (Map<String, String>) authentication.getDetails();
//            Result.success(details);
//        }
//        return null;
//    }

    @GetMapping("/test")
    public String test() {
        return "just test(nothing need)";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
