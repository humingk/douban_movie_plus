package org.humingk.movie.api.user;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;

/**
 * 用户相关API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-user")
@RequestMapping("/user")
public interface UserApi {

    /**
     * auth 登录
     *
     * @param email    用户邮箱
     * @param password 密码
     * @return
     */
    @PostMapping("login")
    Result login(@RequestParam("email") @NotBlank String email,
                 @RequestParam("password") @NotBlank String password);

    /**
     * github 第三方登录
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/github_login")
    void githubLogin(HttpServletResponse response) throws IOException;

    /**
     * github 第三方登录 回调方法
     *
     * @param code  授权码（授权码模式）
     * @param state github_login传入的state
     * @return
     */
    @GetMapping("/github_callback")
    Result githubCallback(@RequestParam("code") String code,
                          @RequestParam("state") String state);

    /**
     * 用户注册
     *
     * @param id       豆瓣个人域名(可选,默认随机UUID)
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    @PostMapping("/register")
    Result register(
            @RequestParam(value = "douban_user_id",
                    required = false,
                    defaultValue = "") String id,
            @RequestParam("email") @NotBlank String email,
            @RequestParam("password") @NotBlank String password);

    /**
     * 更新豆瓣用户ID
     *
     * @param id 豆瓣用户ID
     * @return
     */
    @PutMapping("update_id")
    Result updateId(@RequestParam("id") @NotBlank String id);
}
