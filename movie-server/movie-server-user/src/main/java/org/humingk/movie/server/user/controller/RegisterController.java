package org.humingk.movie.server.user.controller;

import org.humingk.movie.api.user.RegisterApi;
import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册
 *
 * @author humingk
 */
@RestController
public class RegisterController implements RegisterApi {

    /**
     * 用户注册
     *
     * @param email    邮箱
     * @param password 密码
     * @param id       豆瓣个人域名(可选)
     * @return
     */
    @Override
    @PostMapping("/register")
    public Result register(@RequestParam("username") String email, @RequestParam("password") String password, @RequestParam("id") String id) {
        return null;
    }
}
