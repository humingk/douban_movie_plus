package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 电影资源网站
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteResource implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 电影资源网站ID ID<100-正版 ID>100-盗版 */
  private Short id;
  /** 网站中文名 */
  private String nameZh;
  /** 网站官网地址 */
  private String websiteSrc;
}
