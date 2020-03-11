package org.humingk.movie.service.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.entity.Role;
import org.humingk.movie.dal.entity.User;
import org.humingk.movie.dal.entity.UserExample;
import org.humingk.movie.dal.mapper.auto.UserMapper;
import org.humingk.movie.dal.mapper.plus.RoleMapperPlus;
import org.humingk.movie.service.user.entity.SecurityRole;
import org.humingk.movie.service.user.entity.SecurityUser;
import org.humingk.movie.service.user.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户验证服务
 *
 * @author humingk
 */
@Slf4j
@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
  @Autowired private UserMapper userMapper;
  @Autowired private RoleMapperPlus roleMapperPlus;

  /**
   * 根据邮箱获取用户信息
   *
   * @param email
   * @return
   */
  @Override
  public User getUserByEmail(String email) {
    UserExample example = new UserExample();
    example.or().andEmailEqualTo(email);
    return userMapper.selectByExample(example).get(0);
  }

  /**
   * 根据用户ID获取该用户的角色列表
   *
   * @param id
   * @return
   */
  @Override
  public List<Role> getRoleListByUserId(String id) {
    return roleMapperPlus.selectRoleListByUserId(id);
  }

  /**
   * 通过用户登录名(email)获取该用户的用户信息及对应的所有角色名(权限点)
   *
   * @param username
   * @return
   * @throws UsernameNotFoundException
   */
  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException, MyException {
    User user = getUserByEmail(username);
    List<Role> roleList = getRoleListByUserId(user.getId());
    List<SecurityRole> securityRoleList = new ArrayList<>();
    for (Role role : roleList) {
      securityRoleList.add(new SecurityRole(role));
    }
    return new SecurityUser(user, securityRoleList);
  }
}
