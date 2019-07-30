package org.humingk.movie.service.impl;

import org.humingk.movie.baseTest;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.service.ResourceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResourceServiceImplTest extends baseTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void getResourceSearch() {
    }

    @Test
    public void getResourceAll() {
        List<Resource> resourceList=resourceService.getResourceAll("星际穿越",2,1,5);
    }
}