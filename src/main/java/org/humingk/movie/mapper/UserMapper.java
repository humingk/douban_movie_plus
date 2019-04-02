package org.humingk.movie.mapper;

import org.humingk.movie.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

//    --------------

    /**
     * 根据email获取user
     * @param email
     * @return
     */
    User selectByUserEmail(String email);
}