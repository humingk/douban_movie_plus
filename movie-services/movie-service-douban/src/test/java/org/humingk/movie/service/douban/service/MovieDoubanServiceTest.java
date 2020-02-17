package org.humingk.movie.service.douban.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDoubanServiceTest {
  @Autowired private MovieDoubanService movieDoubanService;

  @Test
  public void getMovieDoubanByMovieDoubanId() {
    System.out.println(movieDoubanService.getMovieDoubanByMovieDoubanId(1291561));
  }

  @Test
  public void getMovieDoubanDetailsByMovieDoubanId() {
    //    System.out.println(movieService.getMovieDoubanDetailsByMovieDoubanId(1291561));
    System.out.println(movieDoubanService.getMovieDoubanDetailsByMovieDoubanId(26920842));
  }

  @Test
  public void getSearchTipsMovieDoubanByKeywordStart() {
    System.out.println(
        movieDoubanService.getSearchTipsMovieDoubanListByMovieDoubanKeywordStart("- 歌剧", 0, 10));
  }
}
