package org.humingk.movie.service.user.service.impl;

import org.humingk.movie.common.enumeration.Roles;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.entity.User;
import org.humingk.movie.dal.entity.UserToRole;
import org.humingk.movie.dal.mapper.UserMapper;
import org.humingk.movie.dal.mapper.UserToRoleMapper;
import org.humingk.movie.service.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

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
     * 普通用户注册
     *
     * @param user
     * @return
     */
    @Override
    @NotBlank(message = "用户注册失败")
    public String register(User user) {
        int userInsert, roleInsert;
        try {
            // 用户ID默认为随机UUID
            user.setId(user.getId().isEmpty() ? UUID.randomUUID().toString() : user.getId());
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userInsert = userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            if (e.getCause().getMessage().contains("PRIMARY")) {
                throw new MyException(CodeAndMsg.USER_ID_EXIST, "豆瓣ID:" + user.getId());
            } else {
                throw new MyException(CodeAndMsg.EMAIL_EXIST, "email:" + user.getEmail());
            }
        }
        // 赋予普通用户权限
        roleInsert = userToRoleMapper.insert(new UserToRole(user.getId(), (byte) Roles.USER.id));
        return userInsert == 1 && roleInsert == 1 ? user.getId() : "";
    }
}
