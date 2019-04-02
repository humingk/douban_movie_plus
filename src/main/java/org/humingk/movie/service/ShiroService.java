package org.humingk.movie.service;

import org.humingk.movie.entity.Permission;
import org.humingk.movie.entity.User;

import java.util.List;

public interface ShiroService {

    /**
     * 根据email获取user
     * @param userEmail
     * @return
     */
    User getUserByUserEmail(String userEmail);

    /**
     * 根据user获取该账号的权限
     * @param user
     * @return
     */
    List<Permission> getPermissionsByUser(User user);
}
