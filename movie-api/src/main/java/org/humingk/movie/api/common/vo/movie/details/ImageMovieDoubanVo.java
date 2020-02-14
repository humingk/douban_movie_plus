package org.humingk.movie.api.common.vo.movie.details;

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
@AllArgsConstructor
@NoArgsConstructor
public class ImageMovieDoubanVo implements Serializable {
  /** 豆瓣电影图片ID */
  private Long id;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 豆瓣电影图片链接 sqxs */
  private String urlImageSqxs;
  /** 豆瓣电影图片链接 s */
  private String urlImageS;
  /** 豆瓣电影图片链接 m */
  private String urlImageM;
  /** 豆瓣电影图片链接 L */
  private String urlImageL;

  /** 序号 */
  private Byte sort;

  /** Large版本的长 /px */
  private Integer length;

  /** Large版本的宽 /px */
  private Integer width;
}
