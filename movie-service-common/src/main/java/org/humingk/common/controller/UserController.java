package org.humingk.common.controller;

import org.humingk.common.common.Result;
import org.springframework.beans.factory.annotation.Value;
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

//    /**
//     * 用户登录页面
//     *
//     * @return
//     */
//    //    @AesDecrypt
//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public Result login() {
//        return Result.success("login page");
//    }

    @Value("${server.port}")
    private String port;

    /**
     * test
     *
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "(common)test,from port:" + port;
    }

    /**
     * testfeign
     *
     * @return
     */
    @RequestMapping(value = "testfeign", method = RequestMethod.GET)
    public String test3() {
        return "(common)testfeign,from port:" + port;
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
