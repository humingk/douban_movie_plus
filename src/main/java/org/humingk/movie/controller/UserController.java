package org.humingk.movie.controller;

import org.humingk.movie.common.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
@RequestMapping("/")
public class UserController {

    /**
     * 用户登录页面
     *
     * @return
     */
    //    @AesDecrypt
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Result login() {
        return Result.success("login page");
    }

    /**
     * 用户页面
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "people/{userId}", method = RequestMethod.GET)
    public Result people(@PathVariable("userId") String userId) {
        return Result.success(userId);
    }

}
