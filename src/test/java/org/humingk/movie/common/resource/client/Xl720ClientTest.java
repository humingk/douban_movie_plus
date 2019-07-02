package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
import org.junit.Test;

import java.util.List;

public class Xl720ClientTest extends baseTest {

    @Test
    public void getMovieSearch() {
    }

    @Test
    public void getMovieResource() {
        List<Search> searcheList = new Xl720Client().getMovieSearch("我们", 3);
        for (Search search : searcheList) {
            System.out.println(search.toString());
            List<Resource> resourceList = new Xl720Client().getMovieResource(search);
            for (Resource resource : resourceList) {
                System.out.println(resource.toString());
            }
        }
    }
}