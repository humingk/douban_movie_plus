package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.site.Xl720Resource;
import org.junit.Test;

public class Xl720ClientTest extends baseTest {

    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovie() {
        MovieMap<Xl720Client> movieMap = new Xl720Client().getMovieMap("星际穿越", 3);
        for (Movie movie : movieMap.getMovies()) {
            System.out.println(movie.getMovieName() + " " + movie.getMovieUrl());
            Xl720Resource xl720Resource=new Xl720Client().getMovie(movie);
            System.out.println();
        }
    }
}