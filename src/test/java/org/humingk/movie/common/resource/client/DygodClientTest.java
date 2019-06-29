package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.DygodResource;
import org.junit.Test;

import java.util.Map;

public class DygodClientTest extends baseTest {

    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovie() {
        Map<String, String> movies = new DygodClient().getMovieMap("星际穿越", 3);
        for (String key : movies.keySet()) {
            DygodResource movie = new DygodClient().getMovie(key, movies.get(key));
            System.out.println(movie.getMovieName());
            System.out.println(movie.getMovieUrl());
        }
    }
}