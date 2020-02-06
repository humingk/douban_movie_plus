package org.humingk.movie.server.user.controller;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员管理控制，需要管理员权限
 *
 * @author humingk
 */
@RestController
@RefreshScope
@RequestMapping("/root")
public class RootController {
    @GetMapping("user_list")
    public Result userList() {
        return Result.success("user list(need root)");
    }
}
