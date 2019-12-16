package org.humingk.movie.security.service;

import org.humingk.movie.common.Result;

/**
 * 用户管理业务接口
 *
 * @author humingk
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    Result login(String username, String password);
}
