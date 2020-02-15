package org.humingk.movie.service.imdb.common.dto.celebrity;

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
public class CelebrityImdbDto implements Serializable {
  /** IMDB影人ID nm++00xxx(7) */
  private Long id;

  /** IMDB影人英文名 */
  private String nameEn;

  /** 出生年份 /year */
  private Short birthYear;

  /** 豆瓣影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityDouban;
}
