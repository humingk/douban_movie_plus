package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 城市
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityScene implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 城市ID */
  private Integer id;
  /** 城市中文名 */
  private String nameZh;
  /** 城市英文名 */
  private String nameEn;
}
