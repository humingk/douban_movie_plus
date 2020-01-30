package org.humingk.movie.service.douban.service;

import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.service.douban.service.impl.SearchServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchServiceTest {

    @Autowired
    private SearchServiceImpl searchService;

    @Test
    public void getMovieDoubanListByNameStart() {
        System.out.println();
        List<MovieDouban> result = searchService.getMovieDoubanListByNameStart("星际", 0, 10);
        System.out.println(result.toString());
    }
}