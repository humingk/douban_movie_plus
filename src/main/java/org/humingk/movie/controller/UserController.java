package org.humingk.movie.controller;

import org.humingk.movie.common.Result;
import org.humingk.movie.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param username
     * @param password
     * @return
     */
    //    @AesDecrypt
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        return Result.success(userService.login(username, password));

//        JSONObject jsonObject = JSON.parseObject(params);
//        return new Result(userService.login(
//                jsonObject.getString("username"),
//                jsonObject.getString("password")
//        ));

    }

    /**
     * 用户页面
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "people/{userId}", method = RequestMethod.POST)
    public Result people(@PathVariable("userId") String userId) {
        return Result.success(userId);
    }

}
