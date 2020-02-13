package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 用户ID */
  private String id;
  /** 邮箱 */
  private String email;
  /** 密码 */
  private String password;
}
