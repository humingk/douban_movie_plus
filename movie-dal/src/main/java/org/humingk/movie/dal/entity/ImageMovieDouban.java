package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影图片
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageMovieDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣电影图片ID */
  private Long id;
  /** 豆瓣电影ID */
  private Long idMovieDouban;
  /** 序号 */
  private Byte sort;
  /** 长 /px */
  private Integer length;
  /** 宽 /px */
  private Integer width;
}
