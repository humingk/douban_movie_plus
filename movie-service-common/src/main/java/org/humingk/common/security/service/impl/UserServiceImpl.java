package org.humingk.common.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.humingk.common.common.StatusAndMessage;
import org.humingk.common.exception.MyException;
import org.humingk.common.security.service.MyUserDetailsService;
import org.humingk.common.security.service.UserService;
import org.humingk.common.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 用户业务逻辑实现
 *
 * @author humingk
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtils;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            final Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
            return jwtTokenUtils.generateToken(userDetails);
        } catch (BadCredentialsException e) {
            log.error("认证失败,username:" + username, e);
            throw new MyException(StatusAndMessage.UNAUTHORIZED);
        }
    }
}
