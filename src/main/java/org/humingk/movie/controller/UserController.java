package org.humingk.movie.controller;

import org.humingk.movie.service.UserService;
import org.humingk.movie.tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping(value = "login")
    public Result login() {
        return new Result(200, "", "login");
    }

    /**
     * 获取root权限
     *
     * @return
     */
    @PreAuthorize("hasRole('root')")
    @RequestMapping(value = "root")
    public Result getRoot() {
        return new Result(200, "", "you get root");
    }

    /**
     * 获取user权限
     *
     * @return
     */
    @PreAuthorize("hasRole('user')")
    @RequestMapping(value = "user")
    public Result getUser() {
        return new Result(200, "", "you get user");
    }
}
