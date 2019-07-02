package org.humingk.movie.common.resource.client;

import org.humingk.movie.baseTest;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
import org.junit.Test;

import java.util.List;

public class DygodClientTest extends baseTest {

    @Test
    public void getMovieSearch() {
    }

    @Test
    public void getMovieResource() {
        List<Search> searcheList = new DygodClient().getMovieSearch("星际穿越", 3);
        for (Search search : searcheList) {
            System.out.println(search.toString());
            List<Resource> resourceList = new DygodClient().getMovieResource(search);
            for (Resource resource : resourceList) {
                System.out.println(resource.toString());
            }
        }
    }
}