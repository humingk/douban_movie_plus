package org.humingk.movie.service.common.service.impl;

import org.humingk.movie.service.common.entity.MovieDouban;
import org.humingk.movie.service.common.service.MovieDoubanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDoubanServiceImplTest {

    @Autowired
    private MovieDoubanService movieDoubanService;

    @Test
    public void getMovieDoubanListByNameStart() {
        System.out.println();
        List<MovieDouban> result = movieDoubanService.getMovieDoubanListByNameStart("星际", 0, 10);
        System.out.println();
        for (MovieDouban movie : result) {
            System.out.println(movie.toString());
        }
    }
}