package org.humingk.movie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.humingk.movie.annotation.AesDecrypt;
import org.humingk.movie.common.Result;
import org.humingk.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @AesDecrypt
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestParam("params") String params) {
        JSONObject jsonObject = JSON.parseObject(params);
        return new Result(userService.login(
                jsonObject.getString("username"),
                jsonObject.getString("password")
        ));
    }
}
