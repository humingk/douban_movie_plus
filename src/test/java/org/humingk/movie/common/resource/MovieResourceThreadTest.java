package org.humingk.movie.common.resource;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.pojo.MovieAllResource;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.junit.Test;

import java.util.List;

public class MovieResourceThreadTest extends baseTest {

    @Test
    public void getMovieMapListByKeyword() {
        List<MovieMap<? extends AbstractMovieResourceAdapter>> movieMapList =
                new MovieResourceThread().getMovieMapListByKeyword("星际穿越", 3, 5);
        System.out.println();
    }

    @Test
    public void getMovieResourceByMovieMapList() {
        List<MovieMap<? extends AbstractMovieResourceAdapter>> movieMapList =
                new MovieResourceThread().getMovieMapListByKeyword("星际穿越", 3, 5);
        MovieAllResource movieAllResource = new MovieResourceThread().getMovieResourceByMovieMapList(5, movieMapList);
        System.out.println();
    }
}