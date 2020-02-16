package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbVo;

import java.io.Serializable;

/**
 * 影人基础信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityVo implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 豆瓣影人基础信息 */
  private CelebrityDoubanVo douban;

  /** IMDB影人基础信息 */
  private CelebrityImdbVo imdb;
}
