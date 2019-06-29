package org.humingk.movie.service.impl;

import org.humingk.movie.entity.User;
import org.humingk.movie.entity.UserMovie;
import org.humingk.movie.mapper.UserMapper;
import org.humingk.movie.mapper.UserMovieMapper;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author humingk
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMovieMapper userMovieMapper;

    private static final String WISH = "wish";
    private static final String SEEN = "seen";

    /**
     * 根据email获取user
     *
     * @param userEmail
     * @return
     */
    @Override
    public User getUserInfoByUserEmail(String userEmail) {
        return userMapper.selectUserInfoByUserEmail(userEmail);
    }

    /**
     * 根据userId获取user info
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserInfoByUserId(int userId) {
        return userMapper.selectUserInfoByUserId(userId);
    }

    /**
     * 根据user Label 获取 user info
     *
     * @param label
     * @return
     */
    @Override
    public User getUserInfoByUserLabel(String label) {
        return userMapper.selectUserInfoByUserLabel(label);
    }

    /**
     * 更新用户的wishs Seens名单
     *
     * @param wishsAndSeens
     * @return
     */
    @Override
    public boolean updateWishAndSeen(HashMap<Integer, Integer> wishsAndSeens, String label, String type) {
        try {
            Integer userId = userMapper.selectUserInfoByUserLabel(label).getUserId();
            if (type.equals(WISH)) {
                for (Integer key : wishsAndSeens.keySet()) {
                    UserMovie userMovie = new UserMovie();
                    userMovie.setUserId(userId);
                    userMovie.setMovieId(key);
                    userMovie.setWish(1);
                    userMovie.setSeen(0);
                    userMovie.setRate((float)-1);
                    userMovieMapper.updateWishsAndSeens(userMovie);
                }
                return true;
            }
            else if (type.equals(SEEN)) {
                for (Integer key : wishsAndSeens.keySet()) {
                    UserMovie userMovie = new UserMovie();
                    userMovie.setUserId(userId);
                    userMovie.setMovieId(key);
                    userMovie.setWish(0);
                    userMovie.setSeen(1);
                    userMovie.setRate((float)wishsAndSeens.get(key));
                    userMovieMapper.updateWishsAndSeens(userMovie);
                }
                return true;
            }
        }catch (Exception e){
            logger.error("",e);
            return false;
        }
        return false;
    }

    /**
     * 根据label获取wishs seens
     * @param label
     * @return
     */
    @Override
    public List<UserMovie> getWishsAndSeensByUserLabel(String label){
        int userId=userMapper.selectUserInfoByUserLabel(label).getUserId();
        return userMovieMapper.selectByUserId(userId);

    }
}
