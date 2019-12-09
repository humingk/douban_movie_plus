package org.humingk.movie.service.impl;

import org.humingk.movie.entity.MovieDouban;
import org.humingk.movie.service.MovieDoubanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieDoubanServiceImplTest {
    @Autowired
    private MovieDoubanService movieDoubanService;

    @Test
    void getMovieDoubanListByNameStart() {
        List<MovieDouban> movieDoubanList = movieDoubanService.getMovieDoubanListByNameStart("星",1,3);
        movieDoubanList.forEach((m) -> System.out.println(m.toString()));
    }
}