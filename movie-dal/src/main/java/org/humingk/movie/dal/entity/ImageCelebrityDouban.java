package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣影人图片
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageCelebrityDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人图片 */
  private Long id;
  /** 豆瓣影人ID */
  private Long idCelebrityDouban;
  /** 序号 */
  private Byte sort;
  /** 长 /px */
  private Integer length;
  /** 宽 /px */
  private Integer width;
}
