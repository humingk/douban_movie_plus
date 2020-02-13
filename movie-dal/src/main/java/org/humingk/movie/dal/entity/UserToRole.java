package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户-角色
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserToRole implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 用户ID */
  private String idUser;
  /** 角色ID */
  private Byte idRole;
}
