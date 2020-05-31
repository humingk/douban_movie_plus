package org.humingk.movie.api.common.vo.share;

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
@AllArgsConstructor
@NoArgsConstructor
public class ImageDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣图片ID */
  private Long id;

  /** 豆瓣图片链接 sqxs */
  private String urlImageSqxs;
  /** 豆瓣图片链接 s */
  private String urlImageS;
  /** 豆瓣图片链接 m */
  private String urlImageM;
  /** 豆瓣图片链接 L */
  private String urlImageL;

  /** 序号 */
  private Byte sort;

  /** Large版本的长 /px */
  private Integer length;

  /** Large版本的宽 /px */
  private Integer width;
}
