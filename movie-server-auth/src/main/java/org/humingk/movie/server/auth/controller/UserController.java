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
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
