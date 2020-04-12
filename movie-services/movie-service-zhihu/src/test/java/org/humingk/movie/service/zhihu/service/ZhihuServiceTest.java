package org.humingk.movie.service.zhihu.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ZhihuServiceTest {

  @Autowired private ZhihuService zhihuService;
  private static final Long MOVIE_DOUBAN_ID = 1291561L;

  @Test
  public void getMovieZhihuByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        zhihuService
            .getMovieZhihuByMovieDoubanId(MOVIE_DOUBAN_ID)
            .getMovieZhihu()
            .getIdMovieDouban());
  }
}
