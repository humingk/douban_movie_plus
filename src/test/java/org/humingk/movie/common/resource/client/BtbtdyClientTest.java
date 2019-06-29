package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.resource.BtbtdyResource;
import org.junit.Test;

import java.util.Map;

public class BtbtdyClientTest extends baseTest {

    @Test
    public void getMovieList() {
        System.out.println(new BtbtdyClient().getMovieList("星际", 3));
    }

    @Test
    public void getMovie() {
        Map<String, String> movies = new BtbtdyClient().getMovieList("星际", 3);
        for (String key : movies.keySet()) {
            BtbtdyResource movie = new BtbtdyClient().getMovie(key, movies.get(key));
            System.out.println(movie.getMovieName());
            System.out.println(movie.getMovieUrl());
        }
    }
}