package org.humingk.movie.api.common.vo.celebrity.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影经典台词-影人
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelebrityDoubanToClassicDoubanVo implements Serializable {
  /** 豆瓣影人ID */
  private Long idCelebrityDouban;

  /** 豆瓣影人链接 */
  private String urlCelebrityDouban;

  /** 豆瓣电影经典台词ID */
  private String idClassicDouban;

  /** 豆瓣影人中文名 */
  private String nameZhCelebrityDouban;

  private static final long serialVersionUID = 1L;
}
