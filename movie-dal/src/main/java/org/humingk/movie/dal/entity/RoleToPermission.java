package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色-权限
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleToPermission implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 角色ID */
  private Byte idRole;
  /** 权限ID */
  private Integer idPermission;
}
