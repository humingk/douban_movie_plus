package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.resource.DygodResource;
import org.junit.Test;

import java.util.Map;

public class DygodClientTest extends baseTest {

    @Test
    public void getMovieList() {
        System.out.println(new DygodClient().getMovieList("m",3));
    }

    @Test
    public void getMovie() {
        Map<String, String> movies = new DygodClient().getMovieList("m", 3);
        for (String key : movies.keySet()) {
            DygodResource movie = new DygodClient().getMovie(key, movies.get(key));
            System.out.println(movie.getMovieName());
            System.out.println(movie.getMovieUrl());
        }
    }
}