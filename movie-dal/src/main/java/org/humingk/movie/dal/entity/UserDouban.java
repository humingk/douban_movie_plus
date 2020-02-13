package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣用户
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣用户ID */
  private String id;
  /** 豆瓣名字中文名 */
  private String nameZh;
}
