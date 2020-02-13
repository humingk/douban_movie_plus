package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 洲
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContinentScene implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 洲ID */
  private Byte id;
  /** 洲中文名 */
  private String nameZh;
  /** 洲英文名 */
  private String nameEn;
}
