package org.humingk.movie.service.imdb.service.impl;

import org.humingk.movie.dal.domain.imdb.MovieImdbOfCelebrityImdbDo;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.dal.entity.CelebrityImdbExample;
import org.humingk.movie.dal.mapper.auto.CelebrityImdbMapper;
import org.humingk.movie.dal.mapper.plus.MovieImdbMapperPlus;
import org.humingk.movie.service.imdb.converter.celebrity.CelebrityImdbDetailsDtoConverter;
import org.humingk.movie.service.imdb.dto.celebrity.CelebrityImdbDetailsDto;
import org.humingk.movie.service.imdb.service.CelebrityImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
public class CelebrityImdbServiceImpl implements CelebrityImdbService {
  /** converter */
  @Autowired private CelebrityImdbDetailsDtoConverter celebrityImdbDetailsDtoConverter;
  /** example */
  @Autowired private CelebrityImdbExample celebrityImdbExample;
  /** mapper */
  @Autowired private CelebrityImdbMapper celebrityImdbMapper;

  @Autowired private MovieImdbMapperPlus movieImdbMapperPlus;

  @Override
  public CelebrityImdb getCelebrityImdbByCelebrityImdbId(long id) {
    return celebrityImdbMapper.selectByPrimaryKey(id);
  }

  @Override
  public CelebrityImdb getCelebrityImdbByCelebrityDoubanId(long id) {
    celebrityImdbExample.start().andIdCelebrityDoubanEqualTo(id);
    List<CelebrityImdb> celebrityImdbList =
        celebrityImdbMapper.selectByExample(celebrityImdbExample);
    return celebrityImdbList.size() != 1 ? null : celebrityImdbList.get(0);
  }

  @Override
  public CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityImdbId(long id, int limit) {
    CelebrityImdb celebrityImdb = celebrityImdbMapper.selectByPrimaryKey(id);
    return getCelebrityImdbDetailsByCelebrityImdb(celebrityImdb, limit);
  }

  @Override
  public CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityDoubanId(long id, int limit) {
    celebrityImdbExample.start().andIdCelebrityDoubanEqualTo(id);
    List<CelebrityImdb> celebrityImdbList =
        celebrityImdbMapper.selectByExample(celebrityImdbExample);
    return celebrityImdbList.size() != 1
        ? null
        : getCelebrityImdbDetailsByCelebrityImdb(celebrityImdbList.get(0), limit);
  }

  @Override
  public CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityImdb(
      CelebrityImdb celebrityImdb, int limit) {
    List<MovieImdbOfCelebrityImdbDo> movieImdbOfCelebrityImdbDoList =
        movieImdbMapperPlus.selectMovieImdbOfCelebrityImdbListByCelebrityImdbId(
            celebrityImdb.getId(), limit);
    return celebrityImdbDetailsDtoConverter.to(celebrityImdb, movieImdbOfCelebrityImdbDoList);
  }
}
