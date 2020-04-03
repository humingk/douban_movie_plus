package org.humingk.movie.service.resource.service.impl;

import org.humingk.movie.common.enumeration.CodeAndMsg;
import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.entity.ResourceMovie;
import org.humingk.movie.dal.entity.ResourceMovieExample;
import org.humingk.movie.dal.mapper.auto.ResourceMovieMapper;
import org.humingk.movie.service.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
// @RedisCache
public class ResourceServiceImpl implements ResourceService {
  @Autowired private ResourceMovieMapper resourceMovieMapper;
  @Autowired private ResourceMovieExample resourceMovieExample;

  @Override
  public List<ResourceMovie> getResourceListByMovieDoubanId(Long id) {
    resourceMovieExample.start().andIdMovieDoubanEqualTo(id);
    resourceMovieExample.setOrderByClause("id_type_resource");
    List<ResourceMovie> resultList = resourceMovieMapper.selectByExample(resourceMovieExample);
    if (resultList.isEmpty()) {
      throw new MyException(CodeAndMsg.NO_RESOURCE);
    } else {
      return resultList;
    }
  }
}
