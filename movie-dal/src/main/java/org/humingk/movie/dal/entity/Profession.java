package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 影人职业
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profession implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 影人职业ID */
  private Byte id;
  /** 职业中文名 */
  private String nameZh;
  /** 职业英文名 */
  private String nameEn;
}
