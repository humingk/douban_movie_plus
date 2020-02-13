package org.humingk.movie.api.common.converter;

import org.humingk.movie.dal.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDoubanDetailsVoConverterTest {

  @Autowired private MovieDoubanDetailsVoConverter converter;

  @Test
  public void to() {
    MovieDouban movieDouban = new MovieDouban();
    movieDouban.setId(123L);
    movieDouban.setIdTypeVideo((byte) 2);
    movieDouban.setSummary("dfaga");
    movieDouban.setIdMovieImdb(123345L);
    movieDouban.setHaveSeen(123);
    movieDouban.setIsNetease(true);
    movieDouban.setIsZhihu(true);
    movieDouban.setRuntime((short) 111);
    movieDouban.setNameZh("dagaeg");
    movieDouban.setUrlPoster(123L);

    List<AliasMovieDouban> aliasMovieDoubanList =
        new ArrayList() {
          {
            add(new AliasMovieDouban(11111L, "1111111sssssss"));
            add(new AliasMovieDouban(33333L, "22222ssss"));
          }
        };

    List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList =
        new ArrayList() {
          {
            add(new MovieDoubanToTypeMovie(111L, (short) 11));
            add(new MovieDoubanToTypeMovie(222L, (short) 22));
          }
        };

    List<TagMovie> tagMovieList =
        new ArrayList() {
          {
            add(new TagMovie(111L, "dzsfgg"));
            add(new TagMovie(11L, "dzssssfgg"));
          }
        };

    List<TrailerMovieDouban> trailerMovieDoubanList =
        new ArrayList() {
          {
            add(new TrailerMovieDouban(111L, 333L, "urlddd"));
            add(new TrailerMovieDouban(1L, 33L, "urld"));
          }
        };

    System.out.println(movieDouban);
    System.out.println("--------------");
    System.out.println(aliasMovieDoubanList);
    System.out.println("--------------");
    System.out.println(movieDoubanToTypeMovieList);
    System.out.println("--------------");
    System.out.println(tagMovieList);
    System.out.println("--------------");
    System.out.println(
        converter.to(
            movieDouban,
            aliasMovieDoubanList,
            tagMovieList,
            movieDoubanToTypeMovieList,
            trailerMovieDoubanList));
  }
}
