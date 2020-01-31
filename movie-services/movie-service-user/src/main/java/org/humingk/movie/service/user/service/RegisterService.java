package org.humingk.movie.service.user.service;

import org.humingk.movie.dal.entity.User;

/**
 * 用户注册服务
 *
 * @author humingk
 */
public interface RegisterService {
    /**
     * 用户注册
     *
     * @param user 用户Pojo
     * @return
     */
    int register(User user);
}
