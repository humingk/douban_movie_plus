package org.humingk.movie.api.common.converter;

import org.humingk.movie.dal.entity.MovieDouban;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDoubanVoConverterTest {

  @Autowired private MovieDoubanVoConverter converter;

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

    System.out.println(movieDouban);
    System.out.println("--------------");
    System.out.println(converter.to(movieDouban));
  }
}
