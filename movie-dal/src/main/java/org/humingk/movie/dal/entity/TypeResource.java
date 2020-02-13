package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * cccc
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeResource implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 电影资源类型ID ID<100-在线 ID>100-离线 */
  private Short id;
  /** 资源类型中文名 */
  private String nameZh;
}
