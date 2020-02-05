package org.humingk.movie.api.user;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

/**
 * 用户相关API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-user")
public interface UserApi {

    /**
     * 更新豆瓣用户ID
     *
     * @param doubanUserId 豆瓣用户ID
     * @return
     */
    @PutMapping("douban_user_id")
    Result doubanUserId(@RequestParam("douban_user_id") @NotBlank String doubanUserId);
}
