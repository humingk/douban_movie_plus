package org.humingk.movie.server.user.controller;

import org.humingk.movie.common.entity.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员管理控制，需要管理员权限
 *
 * @author humingk
 */
@RestController
@RequestMapping("/root")
public class RootController {
    @PreAuthorize("hasRole('root')")
    @GetMapping("user_list")
    public Result userList(
            @RequestParam(value = "offset",
                    required = false,
                    defaultValue = "0") int offset,
            @RequestParam(value = "limit",
                    required = false,
                    defaultValue = "10") int limit) {
        return Result.success("user list(need root)");
    }
}
