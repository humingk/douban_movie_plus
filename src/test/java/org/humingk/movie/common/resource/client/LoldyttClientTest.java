package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.LoldyttResource;
import org.junit.Test;

import java.util.Map;

public class LoldyttClientTest extends baseTest {

    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovie() {
        Map<String, String> movies = new LoldyttClient().getMovieMap("星际", 3);
        for (String key : movies.keySet()) {
            LoldyttResource movie = new LoldyttClient().getMovie(key, movies.get(key));
            System.out.println(movie.getMovieName());
            System.out.println(movie.getMovieUrl());
        }
    }
}