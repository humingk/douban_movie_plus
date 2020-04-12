package org.humingk.movie.service.imdb.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieImdbServiceTest {

  @Autowired private MovieImdbService movieImdbService;

  private static final Long MOVIE_DOUBAN_ID = 1291561L;
  private static final Long MOVIE_IMDB_ID = 245429L;

  @Test
  public void getMovieImdbByMovieImdbId() {
    Assert.assertEquals(
        MOVIE_IMDB_ID, movieImdbService.getMovieImdbByMovieImdbId(MOVIE_IMDB_ID).getId());
  }

  @Test
  public void getMovieImdbDetailsByMovieImdbId() {
    Assert.assertEquals(
        MOVIE_IMDB_ID,
        movieImdbService.getMovieImdbDetailsByMovieImdbId(MOVIE_IMDB_ID).getMovieImdb().getId());
  }

  @Test
  public void getMovieImdbByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        movieImdbService.getMovieImdbByMovieDoubanId(MOVIE_DOUBAN_ID).getIdMovieDouban());
  }

  @Test
  public void getMovieImdbDetailsByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        movieImdbService
            .getMovieImdbDetailsByMovieDoubanId(MOVIE_DOUBAN_ID)
            .getMovieImdb()
            .getIdMovieDouban());
  }
}
