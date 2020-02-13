package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 影片种类
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeVideo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 影片类型ID */
  private Byte id;
  /** 影片类型中文名 */
  private String nameZh;
  /** 影片类型英文名 */
  private String nameEn;
}
