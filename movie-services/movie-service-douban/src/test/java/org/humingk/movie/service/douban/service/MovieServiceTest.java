package org.humingk.movie.service.douban.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {

  @Autowired private MovieService movieService;

  @Test
  public void getMovieDoubanByMovieDoubanId() {
    System.out.println(movieService.getMovieDoubanByMovieDoubanId(1291561));
  }

  @Test
  public void getAliasMovieDoubanListByMovieDoubanId() {
    System.out.println(movieService.getAliasMovieDoubanListByMovieDoubanId(1291561));
  }
}
