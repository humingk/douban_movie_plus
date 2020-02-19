package org.humingk.movie.service.resource.service.impl;

import org.humingk.movie.dal.entity.ResourceMovieExample;
import org.humingk.movie.dal.mapper.auto.ResourceMovieMapper;
import org.humingk.movie.service.resource.converter.ResourceMovieDtoConverter;
import org.humingk.movie.service.resource.dto.ResourceMovieDto;
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
  @Autowired private ResourceMovieDtoConverter resourceMovieDtoConverter;

  @Override
  public List<ResourceMovieDto> getResourceListByMovieDoubanId(Long id) {
    resourceMovieExample.start().andIdMovieDoubanEqualTo(id);
    return resourceMovieDtoConverter.toList(
        resourceMovieMapper.selectByExample(resourceMovieExample));
  }
}
