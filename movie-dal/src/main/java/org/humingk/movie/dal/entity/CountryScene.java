package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 国家
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryScene implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 国家ID */
  private Short id;
  /** 国家中文名 */
  private String nameZh;
  /** 国家英文名 */
  private String nameEn;
}
