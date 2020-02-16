package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanDetailsVo;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbDetailsVo;

import java.io.Serializable;

/**
 * 影人详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDetailsVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人详细信息 */
  private CelebrityDoubanDetailsVo douban;
  /** IMDB影人详细信息 */
  private CelebrityImdbDetailsVo imdb;
}
