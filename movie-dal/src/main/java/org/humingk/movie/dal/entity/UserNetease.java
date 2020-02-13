package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 网易云音乐用户
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNetease implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 网易云音乐用户ID */
  private Long id;
  /** 用户中文名 */
  private String nameZh;
}
