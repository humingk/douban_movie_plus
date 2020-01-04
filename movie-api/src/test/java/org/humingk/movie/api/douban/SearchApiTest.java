package org.humingk.movie.api.douban;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchApiTest {

    @Autowired
    private SearchApi searchApi;

    @Test
    public void searchMovieTips() {
        System.out.println(searchApi.searchMovieTips("星际").toString());
    }
}