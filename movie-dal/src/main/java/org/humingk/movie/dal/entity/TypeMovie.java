package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 电影类型
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeMovie implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 电影类型ID */
  private Short id;
  /** 电影类型中文名 */
  private String nameZh;
}
