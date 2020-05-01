package org.humingk.movie.service.douban.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDoubanServiceTest {
  @Autowired private MovieDoubanService movieDoubanService;

  private static final Long MOVIE_DOUBAN_ID = 1291561L;

  @Test
  public void getMovieDoubanByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID, movieDoubanService.getMovieDoubanByMovieDoubanId(MOVIE_DOUBAN_ID).getId());
  }

  @Test
  public void getMovieDoubanDetailsByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        movieDoubanService
            .getMovieDoubanDetailsByMovieDoubanId(MOVIE_DOUBAN_ID)
            .getMovieDouban()
            .getId());
  }

  @Test
  public void getSearchTipsMovieDoubanByKeywordStart() {
    Assert.assertFalse(
        movieDoubanService
            .getSearchTipsMovieDoubanListByMovieDoubanKeywordStart("爱", 0, 10)
            .isEmpty());
  }

  @Test
  public void getSearchResultMovieDoubanListByMovieDoubanKeyword() {
    Assert.assertFalse(
        movieDoubanService
            .getSearchResultMovieDoubanListByMovieDoubanKeyword("爱", 0, 10)
            .isEmpty());
  }

  @Test
  public void getRateMovieDoubanByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        movieDoubanService.getRateMovieDoubanByMovieDoubanId(MOVIE_DOUBAN_ID).getId());
  }
}
