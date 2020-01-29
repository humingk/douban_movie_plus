package org.humingk.movie.api.movie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchApiTest {

    @Autowired
    private SearchApi searchApi;

    @Test
    public void searchMovieTips() {
        System.out.println(searchApi.searchMovieTips("星际").toString());
    }
}