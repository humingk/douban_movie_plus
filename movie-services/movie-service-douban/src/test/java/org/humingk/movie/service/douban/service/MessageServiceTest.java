package org.humingk.movie.service.douban.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageServiceTest {

  @Autowired private MessageService messageService;

  @Test
  public void insertMessage() {
    Assert.assertNotNull(
        messageService.insertMessage("jiangbao", "酱爆", "0.0.0.0", "我酱爆，在这moment，要爆了~"));
    Assert.assertNotNull(messageService.insertMessage("luxun", "鲁迅", "0.0.0.0", "你抓周树人和我鲁迅有什么关系"));
  }

  @Test
  public void getMessageListOrdered() {
    Assert.assertFalse(messageService.getMessageListOrdered("create_time", 0, 10).isEmpty());
    Assert.assertFalse(messageService.getMessageListOrdered("agree", 0, 10).isEmpty());
  }

  @Test
  public void getMessageAmount() {
    Assert.assertNotEquals(0, messageService.getMessageAmount());
  }

  @Test
  public void agree() {
    Assert.assertTrue(messageService.agree("top"));
  }
}
