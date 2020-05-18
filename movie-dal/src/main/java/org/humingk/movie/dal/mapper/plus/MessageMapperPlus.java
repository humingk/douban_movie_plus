package org.humingk.movie.dal.mapper.plus;

import org.humingk.movie.dal.entity.Message;
import org.humingk.movie.dal.entity.MessageExample;

/** @author humingk */
public interface MessageMapperPlus extends BaseMapperPlus<Message, MessageExample> {
  /**
   * 更新agree+1
   *
   * @param id 留言ID
   * @return
   */
  void updateAgreePlusOne(String id);
}
