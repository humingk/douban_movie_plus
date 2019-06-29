package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.Xl720Resource;
import org.junit.Test;

import java.util.Map;

public class Xl720ClientTest extends baseTest {

    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovie() {
        Map<String, String> movies = new Xl720Client().getMovieMap("星际", 3);
        for (String key : movies.keySet()) {
            Xl720Resource movie = new Xl720Client().getMovie(key, movies.get(key));
            System.out.println(movie.getMovieName());
            System.out.println(movie.getMovieUrl());
        }
    }
}