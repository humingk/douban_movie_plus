package org.humingk.movie.service.impl;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import lombok.extern.java.Log;
import org.humingk.movie.entity.Role;
import org.humingk.movie.entity.RoleToPermission;
import org.humingk.movie.entity.User;
import org.humingk.movie.entity.UserToRole;
import org.humingk.movie.service.MyUserDetailsService;
import org.humingk.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humingk
 */
@Log
@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    @Autowired
    private UserService userService;

    /**
     * 通过用户登录名获取该用户所有权限
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        User user = userService.getUserByEmail(username);
        if (user != null) {
            List<Role> roleList = userService.getRoleListByUserId(user.getId());
            user.setAuthorities(roleList);
        }
        return user;
    }
}
