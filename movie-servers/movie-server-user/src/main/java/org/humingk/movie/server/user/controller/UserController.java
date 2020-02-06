package org.humingk.movie.server.user.controller;

import org.humingk.movie.common.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 用户控制
 *
 * @author humingk
 */
@RefreshScope
@RestController
public class UserController {

    @GetMapping("/user_info")
    public Result userInfo(Principal principal) {
        return Result.success(ResponseEntity.ok(principal));
    }

    @Value("${custom.test}")
    private String test;

    @GetMapping("/test_bus_refresh")
    public Result testBusRefresh() {
        return Result.success(test);
    }
}
