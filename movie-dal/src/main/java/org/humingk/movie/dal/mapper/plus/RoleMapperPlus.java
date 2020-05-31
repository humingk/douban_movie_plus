package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.entity.Role;
import org.humingk.movie.dal.entity.RoleExample;

import java.util.List;

/** @author humingk */
public interface RoleMapperPlus extends BaseMapperPlus<Role, RoleExample> {
  /**
   * 获取用户对应的角色列表
   *
   * @param id 用户ID
   * @return
   */
  List<Role> selectRoleListByUserId(String id);
}
