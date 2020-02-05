package org.humingk.movie.api.user;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 用户注册API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-user")
public interface RegisterApi {
    /**
     * 用户注册
     *
     * @param email        邮箱
     * @param password     密码
     * @param doubanUserId 豆瓣个人域名(可选)
     * @return
     */
    @PostMapping("/register")
    Result register(@RequestParam("username") @Email String email,
                    @RequestParam("password") @NotBlank String password,
                    @RequestParam(value = "douban_user_id",
                            required = false,
                            defaultValue = "") String doubanUserId);
}
