package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 留言板
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResVo implements Serializable {

  /** 留言总数 */
  private Long amount;

  /** 留言列表 */
  private List<MessageVo> messageList;

  private static final long serialVersionUID = 1L;
}
