package org.humingk.movie.service;

import org.humingk.movie.entity.User;
import org.humingk.movie.entity.UserMovie;

import java.util.HashMap;
import java.util.List;

/**
 * user Info 不包括 password
 * @author humin
 */
public interface UserService {
    /**
     * 根据email获取user Info
     * @param userEmail
     * @return
     */
    User getUserInfoByUserEmail(String userEmail);

    /**
     * 根据userId获取user info
     * @param userId
     * @return
     */
    User getUserInfoByUserId(int userId);

    /**
     * 根据user Label 获取 user info
     * @param label
     * @return
     */
    User getUserInfoByUserLabel(String label);

    /**
     *
     * 更新用户的wishs Seens名单
     * @param wishsAndSeens
     * @return
     */
    boolean updateWishAndSeen(HashMap<Integer,Integer> wishsAndSeens,String label,String type);

    /**
     * 根据label获取wishs seens
     * @param label
     * @return
     */
    List<UserMovie> getWishsAndSeensByUserLabel(String label);

}
