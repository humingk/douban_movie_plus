package org.humingk.movie.api.common.vo.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣影人基础信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDoubanVo implements Serializable {

  private static final long serialVersionUID = 1L;
  /** 豆瓣影人ID */
  private Long id;

  /** 豆瓣影人链接 */
  private String urlCelebrityDouban;

  /** IMDB影人ID */
  private String idCelebrityImdb;

  /** IMDB影人链接 */
  private String urlCelebrityImdb;

  /** 豆瓣影人中文名 */
  private String nameZh;

  /** 豆瓣影人英文名 */
  private String nameOrigin;

  /** 性别 */
  private String sex;

  /** 生日日期 */
  private String birthDate;

  /** 豆瓣影人海报链接 */
  private String urlPortrait;

  /** 影人简介 */
  private String summary;
}
