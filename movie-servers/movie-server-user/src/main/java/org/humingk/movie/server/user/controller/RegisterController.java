package org.humingk.movie.server.user.controller;

import org.humingk.movie.common.annotation.AesDecrypt;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.dal.entity.User;
import org.humingk.movie.service.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册
 *
 * @author humingk
 */
@Validated
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * 用户注册
     *
     * @param email        邮箱
     * @param password     密码
     * @param userDoubanId 豆瓣个人域名(可选)
     * @return
     */
    @AesDecrypt
    @PostMapping("/register")
    public Result register(@RequestParam("username") @NotBlank String email,
                           @RequestParam("password") @NotBlank String password,
                           @RequestParam(value = "user_douban_id",
                                   required = false,
                                   defaultValue = "") String userDoubanId) {
        String userId = registerService.register(new User(userDoubanId, email, password));
        return userId.isEmpty() ? Result.error(userId) : Result.success(userId);
    }
}
