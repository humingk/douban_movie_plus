package org.humingk.movie.service.resource.service;

import org.humingk.movie.common.exception.MyException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourceServiceTest {

  @Autowired private ResourceService resourceService;

  private static final Long MOVIE_DOUBAN_ID = 1889243L;
  private static final Long MOVIE_NULL_ID = 1111111111L;

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void getResourceListByMovieDoubanId() {
    Assert.assertFalse(
        resourceService.getResourceListByMovieDoubanId(MOVIE_DOUBAN_ID, 10).isEmpty());
    thrown.expect(MyException.class);
    resourceService.getResourceListByMovieDoubanId(MOVIE_NULL_ID, 10);
  }

  @Test
  public void getResourceListByKeyword() {
    Assert.assertFalse(resourceService.getResourceListByKeyword("星", 0, 10).isEmpty());
    thrown.expect(MyException.class);
    resourceService.getResourceListByKeyword("星星大便", 0, 10);
  }
}
