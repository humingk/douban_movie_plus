package org.humingk.movie.api.user;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户注册API
 *
 * @author humingk
 */
@FeignClient("movie-server-user")
public interface RegisterApi {
    /**
     * 用户注册
     *
     * @param email        邮箱
     * @param password     密码
     * @param userDoubanId 豆瓣个人域名(可选)
     * @return
     */
    @PostMapping("/register")
    Result register(@RequestParam("username") String email,
                    @RequestParam("password") String password,
                    @RequestParam(value = "user_douban_id",
                            required = false,
                            defaultValue = "none") String userDoubanId);
}
