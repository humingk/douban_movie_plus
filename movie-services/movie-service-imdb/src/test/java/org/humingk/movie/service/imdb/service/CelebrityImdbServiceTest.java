package org.humingk.movie.service.imdb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CelebrityImdbServiceTest {

  @Autowired private CelebrityImdbService celebrityImdbService;

  @Test
  public void getCelebrityImdbByCelebrityImdbId() {
    System.out.println(celebrityImdbService.getCelebrityImdbByCelebrityImdbId(158));
  }

  @Test
  public void getCelebrityImdbByCelebrityDoubanId() {
    System.out.println(celebrityImdbService.getCelebrityImdbByCelebrityDoubanId(1054450));
  }

  @Test
  public void getCelebrityImdbDetailsByCelebrityImdbId() {
    System.out.println(celebrityImdbService.getCelebrityImdbDetailsByCelebrityImdbId(158));
  }

  @Test
  public void getCelebrityImdbDetailsByCelebrityDoubanId() {

    System.out.println(celebrityImdbService.getCelebrityImdbDetailsByCelebrityDoubanId(1054450));
  }
}
