package org.humingk.movie.server.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/test")
    public String test() {
        return "just test(nothing need)";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
