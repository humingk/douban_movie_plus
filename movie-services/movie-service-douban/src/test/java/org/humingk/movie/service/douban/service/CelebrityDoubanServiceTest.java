package org.humingk.movie.service.douban.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CelebrityDoubanServiceTest {

  @Autowired private CelebrityDoubanService celebrityDoubanService;

  private static final Long CELEBRITY_DOUBAN_ID = 1054439L;

  @Test
  public void getCelebrityDoubanByCelebrityDoubanId() {
    Assert.assertEquals(
        CELEBRITY_DOUBAN_ID,
        celebrityDoubanService.getCelebrityDoubanByCelebrityDoubanId(CELEBRITY_DOUBAN_ID).getId());
  }

  @Test
  public void getCelebrityDoubanDetailsByCelebrityDoubanId() {
    Assert.assertEquals(
        CELEBRITY_DOUBAN_ID,
        celebrityDoubanService
            .getCelebrityDoubanDetailsByCelebrityDoubanId(CELEBRITY_DOUBAN_ID, 10)
            .getCelebrityDouban()
            .getId());
  }

  @Test
  public void getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart() {
    Assert.assertFalse(
        celebrityDoubanService
            .getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart("宫", 0, 10)
            .isEmpty());
  }

  @Test
  public void getSearchResultCelebrityDoubanListByCelebrityDoubanKeyword() {
    Assert.assertFalse(
        celebrityDoubanService
            .getSearchResultCelebrityDoubanListByCelebrityDoubanKeyword("爱", 0, 10)
            .isEmpty());
  }
}
