package org.humingk.movie.api.user;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.PositiveOrZero;

/**
 * ROOT用户相关API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-user")
public interface RootApi {

  /**
   * 普通用户列表
   *
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   */
  @RequestMapping(value = "/root/users_list", method = RequestMethod.GET)
  Result usersList(
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);
}
