package org.humingk.movie.common.resource;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.resource.client.BtbtdyClient;
import org.humingk.movie.common.resource.resource.BtbtdyResource;
import org.junit.Test;

import java.util.List;

public class AbstractMovieResourceAdapterTest extends baseTest {

    @Test
    public void getMovieAllResource() {
    }
    @Test
    public void getResource() {
        AbstractMovieResourceAdapter btbtdy = new BtbtdyClient();
        List<BtbtdyResource> btbtdyResource = btbtdy.getMovieResource("星际", 3);
        for (BtbtdyResource resource : btbtdyResource) {
            System.out.println(resource.getMovieName());
            System.out.println(resource.getMovieUrl());
        }
    }

    @Test
    public void parseResource() {
    }

    @Test
    public void jsoupRequest() {
    }

    @Test
    public void httpUrlConnRequest() {
    }

}