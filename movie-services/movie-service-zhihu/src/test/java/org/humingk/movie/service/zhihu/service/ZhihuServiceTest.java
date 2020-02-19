package org.humingk.movie.service.zhihu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ZhihuServiceTest {

  @Autowired private ZhihuService zhihuService;

  @Test
  public void getMovieZhihuByMovieDoubanId() {
    System.out.println(zhihuService.getMovieZhihuByMovieDoubanId(1291561L));
  }
}
