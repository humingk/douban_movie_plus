package org.humingk.movie.service.user.service;

import org.humingk.movie.dal.entity.User;
import org.springframework.validation.annotation.Validated;

/**
 * 用户注册服务
 *
 * @author humingk
 */
@Validated
public interface RegisterService {
  /**
   * 用户注册
   *
   * @param user 用户Pojo
   * @return 用户ID
   */
  String register(User user);
}
