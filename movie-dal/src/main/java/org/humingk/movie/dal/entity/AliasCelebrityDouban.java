package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 影人别名
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AliasCelebrityDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人ID */
  private Long idCelebrityDouban;
  /** 豆瓣影人别称 */
  private String nameAlias;
  /** 是否为昵称 0-本名 1-昵称 */
  private Boolean isNikename;
}
