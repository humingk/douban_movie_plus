package org.humingk.movie.service.douban.service;

import org.humingk.movie.dal.entity.Message;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 留言板服务
 *
 * @author humingk
 */
@Validated
public interface MessageService {

  /**
   * 留言
   *
   * @param idUser 用户ID
   * @param nickname 用户昵称
   * @param ip 真实ip地址
   * @param content 留言内容
   * @return
   */
  Message insertMessage(String idUser, String nickname, String ip, String content);

  /**
   * 获取排序的留言板信息列表
   *
   * @param order 排序依据
   * @param offset 偏移量
   * @param limit 限制数
   * @return
   */
  List<Message> getMessageListOrdered(String order, int offset, int limit);

  /**
   * 获取留言板信息列表总数
   *
   * @return
   */
  long getMessageAmount();

  /**
   * 赞同
   *
   * @param id 留言ID
   */
  boolean agree(String id);
}
