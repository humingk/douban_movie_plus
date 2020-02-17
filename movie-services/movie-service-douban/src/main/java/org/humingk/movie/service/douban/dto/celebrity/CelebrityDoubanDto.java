package org.humingk.movie.service.douban.dto.celebrity;

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
public class CelebrityDoubanDto implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人ID */
  private Long id;

  /** IMDB影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityImdb;

  /** 豆瓣影人中文名 */
  private String nameZh;

  /** 豆瓣影人英文名 */
  private String nameOrigin;

  /** 性别 0-女 1-男 2-未知 */
  private Byte sex;

  /** 生日日期 /unix */
  private Long birthDate;

  /** 豆瓣影人海报ID */
  private Long urlPortrait;

  /** 影人简介 */
  private String summary;
}
