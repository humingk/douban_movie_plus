package org.humingk.movie.service.impl;

import org.humingk.movie.entity.User;
import org.humingk.movie.mapper.UserMapper;
import org.humingk.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据email获取user
     *
     * @param userEmail
     * @return
     */
    @Override
    public User getUserByUserEmail(String userEmail) {
        User user=userMapper.selectByUserEmail(userEmail);
        return user;
    }
}
