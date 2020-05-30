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

  private static final Long MOVIE_DOUBAN_ID = 1889243L;

  private static final String KEYWORD = "爱";

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
            .getSearchTipsMovieDoubanListByMovieDoubanKeywordStart(KEYWORD, 0, 10)
            .isEmpty());
    Assert.assertTrue(
        movieDoubanService
            .getSearchTipsMovieDoubanListByMovieDoubanKeywordStart("逐梦演艺圈", 0, 10)
            .isEmpty());
  }

  @Test
  public void getSearchResultMovieDoubanListByMovieDoubanKeyword() {
    Assert.assertFalse(
        movieDoubanService
            .getSearchResultMovieDoubanListByMovieDoubanKeyword(KEYWORD, 0, 10)
            .isEmpty());
    Assert.assertTrue(
        movieDoubanService
            .getSearchResultMovieDoubanListByMovieDoubanKeyword("逐梦演艺圈", 0, 10)
            .isEmpty());
  }

  @Test
  public void getRateMovieDoubanByMovieDoubanId() {
    Assert.assertEquals(
        MOVIE_DOUBAN_ID,
        movieDoubanService.getRateMovieDoubanByMovieDoubanId(MOVIE_DOUBAN_ID).getId());
  }
}
