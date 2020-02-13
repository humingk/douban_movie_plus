package org.humingk.movie.dal.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDoubanToClassic implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人ID */
  private Long idCelebrityDouban;
  /** 豆瓣电影经典台词ID */
  private Long idClassicDouban;
}
