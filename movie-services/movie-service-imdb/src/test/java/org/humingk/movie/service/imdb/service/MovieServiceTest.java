package org.humingk.movie.service.imdb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {

  @Autowired private MovieService movieService;

  @Test
  public void getMovieImdbByMovieImdbId() {
    System.out.println(movieService.getMovieImdbByMovieImdbId(245429));
  }

  @Test
  public void getMovieImdbDetailsByMovieImdbId() {
    System.out.println(movieService.getMovieImdbDetailsByMovieImdbId(245429));
  }
}
