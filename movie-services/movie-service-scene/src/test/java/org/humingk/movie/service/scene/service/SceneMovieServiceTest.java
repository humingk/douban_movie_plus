package org.humingk.movie.service.scene.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SceneMovieServiceTest {

  @Autowired private SceneMovieService sceneMovieService;

  @Test
  public void getMovieSceneBriefByMovieDoubanId() {
    System.out.println(sceneMovieService.getMovieSceneBriefByMovieDoubanId(1291875L));
  }

  @Test
  public void getMovieSceneAllByMovieDoubanId() {
    System.out.println(sceneMovieService.getMovieSceneAllByMovieDoubanId(1291875L));
  }
}
