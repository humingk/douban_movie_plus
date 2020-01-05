package org.humingk.movie.server.auth.controller;

import org.humingk.movie.common.entity.Result;
import org.humingk.movie.server.auth.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户Token
 *
 * @author humingk
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    /**
     * 通过token获取用户名
     *
     * @param token
     * @return
     */
    @PostMapping("/principal")
    public Result getUserInfo(@RequestParam("token") String token) {
        return Result.success(JwtTokenUtil.getUsernameFromToken(token));
    }

    /**
     * 注销登录，清除token
     *
     * @param token
     * @return
     */
    @PostMapping("/logout")
    public Result logout(@RequestParam("token") String token) {
        if (consumerTokenServices.revokeToken(token)) {
            return Result.success("注销成功");
        } else {
            return Result.error("注销失败");
        }
    }

    /**
     * jwt解析Token
     *
     * @param token
     * @return
     */
    @PostMapping("/decodeToken")
    public Result decodeToken(@RequestParam("token") String token) {
        return Result.success(JwtTokenUtil.getClaimsFromToken(token));
    }
}
