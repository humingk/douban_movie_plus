package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 电影奖项
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AwardMovie implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 电影奖项ID */
  private String id;
  /** 电影奖项中文名 */
  private String nameZh;
}
