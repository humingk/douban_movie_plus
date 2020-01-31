package org.humingk.movie.service.user.service.impl;

import org.humingk.movie.dal.entity.User;
import org.humingk.movie.dal.entity.UserToRole;
import org.humingk.movie.dal.mapper.UserMapper;
import org.humingk.movie.dal.mapper.UserToRoleMapper;
import org.humingk.movie.service.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author humingk
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserToRoleMapper userToRoleMapper;

    /**
     * 用户注册
     *
     * @param user 用户Pojo
     * @return
     */
    @Override
    public int register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userToRoleMapper.insert(new UserToRole(user.getId(), (byte) 2));
        return userMapper.insert(user);
    }
}
