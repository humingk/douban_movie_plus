package org.humingk.movie.service.imdb.service.impl;

import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.MovieImdbMapper;
import org.humingk.movie.dal.mapper.auto.MovieImdbToCelebrityImdbMapper;
import org.humingk.movie.dal.mapper.auto.MovieImdbToTypeMovieMapper;
import org.humingk.movie.dal.mapper.auto.RateImdbMapper;
import org.humingk.movie.service.imdb.common.converter.MovieImdbDetailsDtoConverter;
import org.humingk.movie.service.imdb.common.converter.MovieImdbDtoConverter;
import org.humingk.movie.service.imdb.common.dto.MovieImdbDetailsDto;
import org.humingk.movie.service.imdb.common.dto.MovieImdbDto;
import org.humingk.movie.service.imdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
// @RedisCache
public class MovieServiceImpl implements MovieService {

  /** converter */
  @Autowired private MovieImdbDtoConverter movieImdbDtoConverter;

  @Autowired private MovieImdbDetailsDtoConverter movieImdbDetailsDtoConverter;
  /** example */
  @Autowired private MovieImdbToTypeMovieExample movieImdbToTypeMovieExample;

  @Autowired private MovieImdbToCelebrityImdbExample movieImdbToCelebrityImdbExample;
  /** mapper */
  @Autowired private MovieImdbMapper movieImdbMapper;

  @Autowired private RateImdbMapper rateImdbMapper;
  @Autowired private MovieImdbToTypeMovieMapper movieImdbToTypeMovieMapper;
  @Autowired private MovieImdbToCelebrityImdbMapper movieImdbToCelebrityImdbMapper;

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
    /** IMDB电影-影人列表 */
    movieImdbToCelebrityImdbExample.start().andIdMovieImdbEqualTo(id);
    List<MovieImdbToCelebrityImdb> movieImdbToCelebrityImdbList =
        movieImdbToCelebrityImdbMapper.selectByExample(movieImdbToCelebrityImdbExample);
    return movieImdbDetailsDtoConverter.to(
        movieImdb, rateImdb, movieImdbToTypeMovieList, movieImdbToCelebrityImdbList);
  }
}
