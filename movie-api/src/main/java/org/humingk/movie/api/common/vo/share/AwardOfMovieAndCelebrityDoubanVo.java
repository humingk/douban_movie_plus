package org.humingk.movie.api.common.vo.share;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影相关奖项
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AwardOfMovieAndCelebrityDoubanVo implements Serializable {
  private static final long serialVersionUID = 1L;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 获奖奖项ID */
  private String idAwardMovie;

  /** 奖项中文名 */
  private String nameZh;

  /** 奖项链接 */
  private String urlAward;

  /** 获奖豆瓣影人ID */
  private Long idCelebrityDouban;

  /** 豆瓣影人链接 */
  private String urlCelebrityDouban;

  /** 奖项的类别中文名 */
  private String typeAward;

  /** 获奖奖项届数 */
  private Short awardTh;

  /** 是否提名 0-仅提名未获奖 1-已提名且获奖 */
  private Byte isNominated;
}
