package org.humingk.movie.server.auth.controller;

import io.jsonwebtoken.Jwts;
import org.humingk.movie.common.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
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

//    /**
//     * 采用RemoteTokenServices方式对token验证
//     *
//     * @param principal
//     * @return
//     */
//    @GetMapping("/user")
//    public Principal user(Principal principal) {
//        System.out.println();
//        return principal;
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
