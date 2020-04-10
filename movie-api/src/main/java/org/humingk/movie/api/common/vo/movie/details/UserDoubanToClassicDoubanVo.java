package org.humingk.movie.api.common.vo.movie.details;

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
@AllArgsConstructor
@NoArgsConstructor
public class UserDoubanToClassicDoubanVo implements Serializable {
  /** 豆瓣用户ID 0-未登录用户 */
  private String idUserDouban;

  /** 豆瓣用户链接 */
  private String urlUserDouban;

  /** 豆瓣电影经典台词ID */
  private String idClassicDouban;

  /** 用户中文名 */
  private String nameZhUserDouban;

  /** 豆瓣用户收录日期时间 */
  private String recordDatetime;

  /** 豆瓣用户评价 */
  private String description;

  private static final long serialVersionUID = 1L;
}
