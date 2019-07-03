package org.humingk.movie.common.resource;

import org.humingk.movie.baseTest;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
import org.junit.Test;

import java.util.List;

public class MovieResourceThreadTest extends baseTest {

    @Test
    public void getResourceSearch() {
    }

    @Test
    public void getResourceAll() {
        List<Search> searchList = new MovieResourceThread().getResourceSearch("星际穿越", 1, 5);
        for (Search search : searchList) {
            System.out.println(search.toString());
        }
        System.out.println("---------------------------------");
        List<Resource> resourceList = new MovieResourceThread().getResourceAll(10, searchList);
        for (Resource resource : resourceList) {
            System.out.println(resource.toString());
        }
    }
}