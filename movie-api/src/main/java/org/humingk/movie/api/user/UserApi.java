package org.humingk.movie.api.user;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.Principal;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

// 用于生成API文档
//import org.springframework.web.bind.annotation.RestController;
//@RestController

/**
 * 普通用户相关API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-user")
public interface UserApi {

    /**
     * auth 登录
     *
     * @param email    用户邮箱
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    Result login(@RequestParam("email") @NotBlank String email,
                 @RequestParam("password") @NotBlank String password);

    /**
     * github 第三方登录
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/user/github_login", method = RequestMethod.GET)
    void githubLogin(HttpServletResponse response) throws IOException;

    /**
     * github 第三方登录 回调方法
     *
     * @param code  授权码（授权码模式）
     * @param state github_login传入的state
     * @return
     */
    @RequestMapping(value = "/user/github_callback", method = RequestMethod.GET)
    Result githubCallback(@RequestParam("code") @NotBlank String code,
                          @RequestParam("state") @NotBlank String state);

    /**
     * 用户注册
     *
     * @param id       豆瓣个人域名(可选,默认随机UUID)
     * @param email    邮箱
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    Result register(
            @RequestParam(value = "id",
                    required = false,
                    defaultValue = "") @NotBlank String id,
            @RequestParam("email") @NotBlank String email,
            @RequestParam("password") @NotBlank String password);

    /**
     * 当前用户信息
     *
     * @param principal Authorization
     * @return
     */
    @RequestMapping(value = "/user/user_info", method = RequestMethod.GET, consumes = APPLICATION_JSON_VALUE)
    Result userInfo(@RequestBody @NotNull Principal principal);

    /**
     * 更新豆瓣用户ID
     *
     * @param id 豆瓣用户ID
     * @return
     */
    @RequestMapping(value = "/user/update_id", method = RequestMethod.PUT)
    Result updateId(@RequestParam("id") @NotBlank String id);
}
