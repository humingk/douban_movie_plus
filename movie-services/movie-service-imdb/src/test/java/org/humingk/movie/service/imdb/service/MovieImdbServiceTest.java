package org.humingk.movie.service.imdb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieImdbServiceTest {

  @Autowired private MovieImdbService movieImdbService;

  @Test
  public void getMovieImdbByMovieImdbId() {
    System.out.println(movieImdbService.getMovieImdbByMovieImdbId(245429));
  }

  @Test
  public void getMovieImdbDetailsByMovieImdbId() {
    System.out.println(movieImdbService.getMovieImdbDetailsByMovieImdbId(245429));
  }

  @Test
  public void getMovieImdbByMovieDoubanId() {
    System.out.println(movieImdbService.getMovieImdbByMovieDoubanId(1291561));
  }

  @Test
  public void getMovieImdbDetailsByMovieDoubanId() {
    System.out.println(movieImdbService.getMovieImdbDetailsByMovieDoubanId(1291561));
  }
}
