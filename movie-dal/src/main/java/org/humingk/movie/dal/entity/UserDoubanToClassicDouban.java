package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影经典台词-豆瓣用户
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDoubanToClassicDouban implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣用户ID */
  private String idUserDouban;
  /** 豆瓣电影经典台词ID */
  private Long idClassicDouban;
  /** 豆瓣用户收录时间 /unix */
  private Long recordDatetime;
  /** 豆瓣用户评价 */
  private String description;
}
