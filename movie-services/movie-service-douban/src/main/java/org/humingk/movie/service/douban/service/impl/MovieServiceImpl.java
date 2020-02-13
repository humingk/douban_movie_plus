package org.humingk.movie.service.douban.service.impl;

import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.*;
import org.humingk.movie.service.douban.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
@RedisCache
public class MovieServiceImpl implements MovieService {
  @Autowired private MovieDoubanMapper movieDoubanMapper;
  @Autowired private AliasMovieDoubanMapper aliasMovieDoubanMapper;
  @Autowired private TagMovieMapper tagMovieMapper;
  @Autowired private MovieDoubanToTypeMovieMapper movieDoubanToTypeMovieMapper;
  @Autowired private TrailerMovieDoubanMapper trailerMovieDoubanMapper;

  @Override
  public MovieDouban getMovieDoubanByMovieDoubanId(long id) {
    return movieDoubanMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<AliasMovieDouban> getAliasMovieDoubanListByMovieDoubanId(long id) {
    AliasMovieDoubanExample example = new AliasMovieDoubanExample();
    example.or().andIdMovieDoubanEqualTo(id);
    return aliasMovieDoubanMapper.selectByExample(example);
  }

  @Override
  public List<TagMovie> getTagMovieDoubanListByMovieDoubanId(long id) {
    TagMovieExample example = new TagMovieExample();
    example.or().andIdMovieDoubanEqualTo(id);
    return tagMovieMapper.selectByExample(example);
  }

  @Override
  public List<MovieDoubanToTypeMovie> getMovieDoubanToTypeMovieListByMovieDoubanId(long id) {
    MovieDoubanToTypeMovieExample example = new MovieDoubanToTypeMovieExample();
    example.or().andIdMovieDoubanEqualTo(id);
    return movieDoubanToTypeMovieMapper.selectByExample(example);
  }

  @Override
  public List<TrailerMovieDouban> getTrailerMovieDoubanListByMovieDoubanId(long id) {
    TrailerMovieDoubanExample example = new TrailerMovieDoubanExample();
    example.or().andIdEqualTo(id);
    return trailerMovieDoubanMapper.selectByExample(example);
  }
}
