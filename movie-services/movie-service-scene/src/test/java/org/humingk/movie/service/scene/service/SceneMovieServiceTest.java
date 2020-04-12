package org.humingk.movie.service.scene.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SceneMovieServiceTest {

  @Autowired private SceneMovieService sceneMovieService;

  private static final Long MOVIE_DOUBAN_ID = 1291875L;

  @Test
  public void getMovieSceneBriefByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        sceneMovieService
            .getMovieSceneBriefByMovieDoubanId(MOVIE_DOUBAN_ID)
            .getMovieScene()
            .getIdMovieDouban());
  }

  @Test
  public void getMovieSceneAllByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        sceneMovieService
            .getMovieSceneAllByMovieDoubanId(MOVIE_DOUBAN_ID)
            .getMovieScene()
            .getIdMovieDouban());
  }
}
