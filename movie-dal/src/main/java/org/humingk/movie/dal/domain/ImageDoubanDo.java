package org.humingk.movie.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣图片
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDoubanDo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣图片ID */
  private Long id;
  /** 序号 */
  private Byte sort;

  /** 长 /px */
  private Integer length;

  /** 宽 /px */
  private Integer width;
}
