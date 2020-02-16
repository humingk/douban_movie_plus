package org.humingk.movie.api.common.vo.celebrity.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣影人别称
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AliasCelebrityDoubanVo implements Serializable {
  /** 豆瓣影人别称 */
  private String nameAlias;

  /** 是否为昵称 0-本名 1-昵称 */
  private Byte isNikename;
}
