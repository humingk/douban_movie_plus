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
     *
     * @param email
     * @return
     */
    User selectByUserEmail(String email);

    /**
     * 根据email获取user INFO 不包含密码
     *
     * @param email
     * @return
     */
    User selectUserInfoByUserEmail(String email);

    /**
     * 根据userId 获取 user info
     * @param userId
     * @return
     */
    User selectUserInfoByUserId(int userId);

    /**
     * 根据user label 获取 user info
     * @param label
     * @return
     */
    User selectUserInfoByUserLabel(String label);

}