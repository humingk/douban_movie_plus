package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 留言板
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVo implements Serializable {
  /** 留言ID */
  private String id;

  /** 用户ID */
  private String idUser;

  /** 用户昵称 */
  private String nickname;

  /** IP地址 */
  private String ip;

  /** 留言内容 */
  private String content;

  /** 留言时间 */
  private String createTime;

  /** 赞同数 */
  private Integer agree;

  private static final long serialVersionUID = 1L;
}
