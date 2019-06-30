package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.site.DygodResource;
import org.junit.Test;

public class DygodClientTest extends baseTest {

    @Test
    public void getMovieList() {
    }

    @Test
    public void getMovie() {
        MovieMap<DygodClient> movieMap = new DygodClient().getMovieMap("星际穿越", 3);
        for (Movie movie : movieMap.getMovies()) {
            System.out.println(movie.getMovieName() + " " + movie.getMovieUrl());
            DygodResource dygodResource=new DygodClient().getMovie(movie);
            System.out.println();
        }
    }
}