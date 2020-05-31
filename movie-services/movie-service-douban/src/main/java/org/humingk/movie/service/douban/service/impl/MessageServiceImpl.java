package org.humingk.movie.service.douban.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.entity.Message;
import org.humingk.movie.dal.entity.MessageExample;
import org.humingk.movie.dal.mapper.auto.MessageMapper;
import org.humingk.movie.dal.mapper.plus.MessageMapperPlus;
import org.humingk.movie.service.douban.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/** @author humingk */
@Service
public class MessageServiceImpl implements MessageService {

  private static final String CREATE_TIME = "create_time";
  private static final String AGREE = "agree";

  @Autowired private MessageExample messageExample;
  @Autowired private MessageMapper messageMapper;
  @Autowired private MessageMapperPlus messageMapperPlus;

  @Override
  public Message insertMessage(String idUser, String nickname, String ip, String content) {
    String id = UUID.randomUUID().toString();
    messageMapper.insert(
        new Message(id, idUser, nickname, ip, content, System.currentTimeMillis(), 0));
    return messageMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<Message> getMessageListOrdered(String order, int offset, int limit) {
    if (CREATE_TIME.equals(order) || AGREE.equals(order)) {
      messageExample.start();
      messageExample.setOrderByClause(order + " DESC");
      PageHelper.offsetPage(offset, limit);
      return messageMapper.selectByExample(messageExample);
    }
    throw new MyException(CodeAndMsg.PARAMTER, "排序依据错误");
  }

  @Override
  public long getMessageAmount() {
    messageExample.start();
    return messageMapper.countByExample(messageExample);
  }

  @Override
  public boolean agree(String id) {
    messageMapperPlus.updateAgreePlusOne(id);
    return true;
  }
}
