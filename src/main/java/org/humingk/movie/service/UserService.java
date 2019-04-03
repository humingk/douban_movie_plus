package org.humingk.movie.service;

import org.humingk.movie.entity.User;

/**
 * @author humin
 */
public interface UserService {
    /**
     * 根据email获取user
     * @param userEmail
     * @return
     */
    User getUserByUserEmail(String userEmail);
}
