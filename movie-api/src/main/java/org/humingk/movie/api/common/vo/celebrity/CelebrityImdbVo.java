package org.humingk.movie.api.common.vo.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * IMDB影人基础信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityImdbVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** IMDB影人ID */
  private String id;

  /** IMDB影人英文名 */
  private String nameEn;

  /** 出生年份 /year */
  private Short birthYear;

  /** 豆瓣影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityDouban;
}
