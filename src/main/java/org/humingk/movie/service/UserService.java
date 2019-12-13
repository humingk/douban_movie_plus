package org.humingk.movie.service;

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
    String login(String username, String password);
}
