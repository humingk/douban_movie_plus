package org.humingk.movie.server.user.controller;

import org.humingk.movie.api.user.RegisterApi;
import org.humingk.movie.common.annotation.AesDecrypt;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.dal.entity.User;
import org.humingk.movie.service.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Override
    @AesDecrypt
    @PostMapping("/register")
    public Result register(@RequestParam("username") String email,
                           @RequestParam("password") String password,
                           @RequestParam(value = "user_douban_id",
                                   required = false,
                                   defaultValue = "id is none") String userDoubanId) {
        String userId = registerService.register(new User(userDoubanId, email, password));
        return "register fail".equals(userId) ? Result.error(userId) : Result.success(userId);
    }
}
