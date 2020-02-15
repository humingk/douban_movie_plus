package org.humingk.movie.service.imdb.service.impl;

import org.humingk.movie.dal.domain.CelebrityImdbOfMovieImdbDo;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.*;
import org.humingk.movie.dal.mapper.plus.CelebrityImdbMapperPlus;
import org.humingk.movie.service.imdb.common.converter.movie.MovieImdbDetailsDtoConverter;
import org.humingk.movie.service.imdb.common.converter.movie.MovieImdbDtoConverter;
import org.humingk.movie.service.imdb.common.dto.movie.MovieImdbDetailsDto;
import org.humingk.movie.service.imdb.common.dto.movie.MovieImdbDto;
import org.humingk.movie.service.imdb.service.MovieImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
// @RedisCache
public class MovieImdbServiceImpl implements MovieImdbService {

  /** converter */
  @Autowired private MovieImdbDtoConverter movieImdbDtoConverter;

  @Autowired private MovieImdbDetailsDtoConverter movieImdbDetailsDtoConverter;
  /** example */
  @Autowired private MovieImdbToTypeMovieExample movieImdbToTypeMovieExample;

  /** mapper */
  @Autowired private MovieImdbMapper movieImdbMapper;

  @Autowired private RateImdbMapper rateImdbMapper;
  @Autowired private MovieImdbToTypeMovieMapper movieImdbToTypeMovieMapper;
  @Autowired private CelebrityImdbMapperPlus celebrityImdbMapperPlus;

  @Override
  public MovieImdbDto getMovieImdbByMovieImdbId(long id) {
    return movieImdbDtoConverter.to(movieImdbMapper.selectByPrimaryKey(id));
  }

  @Override
  public MovieImdbDetailsDto getMovieImdbDetailsByMovieImdbId(long id) {
    /** IMDB电影基础信息 */
    MovieImdb movieImdb = movieImdbMapper.selectByPrimaryKey(id);
    /** IMDB电影评分信息（包括烂番茄、MTC） */
    RateImdb rateImdb = rateImdbMapper.selectByPrimaryKey(id);
    /** IMDB电影-类型列表 */
    movieImdbToTypeMovieExample.start().andIdMovieImdbEqualTo(id);
    List<MovieImdbToTypeMovie> movieImdbToTypeMovieList =
        movieImdbToTypeMovieMapper.selectByExample(movieImdbToTypeMovieExample);
    /** 与IMDB电影相关的IMDB影人列表 */
    List<CelebrityImdbOfMovieImdbDo> celebrityImdbOfMovieImdbDoList =
        celebrityImdbMapperPlus.selectCelebrityImdbOfMovieImdbListByMovieImdbId(id);
    return movieImdbDetailsDtoConverter.to(
        movieImdb, rateImdb, movieImdbToTypeMovieList, celebrityImdbOfMovieImdbDoList);
  }
}
