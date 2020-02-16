package org.humingk.movie.service.imdb.service.impl;

import org.humingk.movie.dal.domain.MovieImdbOfCelebrityImdbDo;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.dal.entity.CelebrityImdbExample;
import org.humingk.movie.dal.mapper.auto.CelebrityImdbMapper;
import org.humingk.movie.dal.mapper.plus.MovieImdbMapperPlus;
import org.humingk.movie.service.imdb.common.converter.celebrity.CelebrityImdbDetailsDtoConverter;
import org.humingk.movie.service.imdb.common.converter.celebrity.CelebrityImdbDtoConverter;
import org.humingk.movie.service.imdb.common.dto.celebrity.CelebrityImdbDetailsDto;
import org.humingk.movie.service.imdb.common.dto.celebrity.CelebrityImdbDto;
import org.humingk.movie.service.imdb.service.CelebrityImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
public class CelebrityImdbServiceImpl implements CelebrityImdbService {
  /** converter */
  @Autowired private CelebrityImdbDtoConverter celebrityImdbDtoConverter;

  @Autowired private CelebrityImdbDetailsDtoConverter celebrityImdbDetailsDtoConverter;
  /** example */
  @Autowired private CelebrityImdbExample celebrityImdbExample;
  /** mapper */
  @Autowired private CelebrityImdbMapper celebrityImdbMapper;

  @Autowired private MovieImdbMapperPlus movieImdbMapperPlus;

  @Override
  public CelebrityImdbDto getCelebrityImdbByCelebrityImdbId(long id) {
    return celebrityImdbDtoConverter.to(celebrityImdbMapper.selectByPrimaryKey(id));
  }

  @Override
  public CelebrityImdbDto getCelebrityImdbByCelebrityDoubanId(long id) {
    celebrityImdbExample.start().andIdCelebrityDoubanEqualTo(id);
    List<CelebrityImdb> celebrityImdbList =
        celebrityImdbMapper.selectByExample(celebrityImdbExample);
    return celebrityImdbList.size() != 1
        ? null
        : celebrityImdbDtoConverter.to(celebrityImdbList.get(0));
  }

  @Override
  public CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityImdbId(long id) {
    CelebrityImdb celebrityImdb = celebrityImdbMapper.selectByPrimaryKey(id);
    return getCelebrityImdbDetailsByCelebrityImdb(celebrityImdb);
  }

  @Override
  public CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityDoubanId(long id) {
    celebrityImdbExample.start().andIdCelebrityDoubanEqualTo(id);
    List<CelebrityImdb> celebrityImdbList =
        celebrityImdbMapper.selectByExample(celebrityImdbExample);
    return celebrityImdbList.size() != 1
        ? null
        : getCelebrityImdbDetailsByCelebrityImdb(celebrityImdbList.get(0));
  }

  /**
   * 根据IMDB基础信息获取IMDB影人详细信息
   *
   * @param celebrityImdb IMDB基础信息
   * @return
   */
  public CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityImdb(
      CelebrityImdb celebrityImdb) {
    List<MovieImdbOfCelebrityImdbDo> movieImdbOfCelebrityImdbDoList =
        movieImdbMapperPlus.selectMovieImdbOfCelebrityImdbListByCelebrityImdbId(
            celebrityImdb.getId());
    return celebrityImdbDetailsDtoConverter.to(celebrityImdb, movieImdbOfCelebrityImdbDoList);
  }
}
