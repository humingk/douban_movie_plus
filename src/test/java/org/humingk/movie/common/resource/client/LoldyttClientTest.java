package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.site.LoldyttResource;
import org.junit.Test;

public class LoldyttClientTest extends baseTest {

    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovie() {
        MovieMap<LoldyttClient> movieMap = new LoldyttClient().getMovieMap("星际穿越", 3);
        for (Movie movie : movieMap.getMovies()) {
            System.out.println(movie.getMovieName() + " " + movie.getMovieUrl());
            LoldyttResource loldyttResource = new LoldyttClient().getMovie(movie);
            System.out.println();
        }
    }
}