package org.humingk.movie.service.resource.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceServiceTest {

  @Autowired private ResourceService resourceService;

  @Test
  public void getResourceListByMovieDoubanId() {
    System.out.println(resourceService.getResourceListByMovieDoubanId(3711760L));
  }
}
