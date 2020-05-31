package org.humingk.movie.service.imdb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CelebrityImdbServiceTest {

  @Autowired private CelebrityImdbService celebrityImdbService;

  private static final Long CELEBRITY_DOUBAN_ID = 1054439L;
  private static final Long CELEBRITY_IMDB_ID = 158L;

  @Test
  public void getCelebrityImdbByCelebrityImdbId() {
    Assert.assertEquals(
        CELEBRITY_IMDB_ID,
        celebrityImdbService.getCelebrityImdbByCelebrityImdbId(CELEBRITY_IMDB_ID).getId());
  }

  @Test
  public void getCelebrityImdbByCelebrityDoubanId() {
    Assert.assertEquals(
        CELEBRITY_DOUBAN_ID,
        celebrityImdbService
            .getCelebrityImdbByCelebrityDoubanId(CELEBRITY_DOUBAN_ID)
            .getIdCelebrityDouban());
  }

  @Test
  public void getCelebrityImdbDetailsByCelebrityImdbId() {
    Assert.assertEquals(
        CELEBRITY_IMDB_ID,
        celebrityImdbService
            .getCelebrityImdbDetailsByCelebrityImdbId(CELEBRITY_IMDB_ID, 10)
            .getCelebrityImdb()
            .getId());
  }

  @Test
  public void getCelebrityImdbDetailsByCelebrityDoubanId() {
    Assert.assertEquals(
        CELEBRITY_DOUBAN_ID,
        celebrityImdbService
            .getCelebrityImdbDetailsByCelebrityDoubanId(CELEBRITY_DOUBAN_ID, 10)
            .getCelebrityImdb()
            .getIdCelebrityDouban());
  }
}
