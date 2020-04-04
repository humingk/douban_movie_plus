package org.humingk.movie.service.imdb.service.impl;

import org.humingk.movie.dal.domain.imdb.CelebrityImdbOfMovieImdbDo;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.MovieImdbMapper;
import org.humingk.movie.dal.mapper.auto.MovieImdbToTypeMovieMapper;
import org.humingk.movie.dal.mapper.auto.RateImdbMapper;
import org.humingk.movie.dal.mapper.plus.CelebrityImdbMapperPlus;
import org.humingk.movie.service.imdb.converter.movie.MovieImdbDetailsDtoConverter;
import org.humingk.movie.service.imdb.dto.movie.MovieImdbDetailsDto;
import org.humingk.movie.service.imdb.service.MovieImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
// @RedisCache
public class MovieImdbServiceImpl implements MovieImdbService {

  /** converter */
  @Autowired private MovieImdbDetailsDtoConverter movieImdbDetailsDtoConverter;
  /** example */
  @Autowired private MovieImdbToTypeMovieExample movieImdbToTypeMovieExample;

  @Autowired private MovieImdbExample movieImdbExample;

  /** mapper */
  @Autowired private MovieImdbMapper movieImdbMapper;

  @Autowired private RateImdbMapper rateImdbMapper;
  @Autowired private MovieImdbToTypeMovieMapper movieImdbToTypeMovieMapper;
  @Autowired private CelebrityImdbMapperPlus celebrityImdbMapperPlus;

  @Override
  public MovieImdb getMovieImdbByMovieImdbId(long id) {
    return movieImdbMapper.selectByPrimaryKey(id);
  }

  @Override
  public MovieImdb getMovieImdbByMovieDoubanId(long id) {
    movieImdbExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieImdb> movieImdbList = movieImdbMapper.selectByExample(movieImdbExample);
    return movieImdbList.size() != 1
        ? null
        : movieImdbMapper.selectByExample(movieImdbExample).get(0);
  }

  @Override
  public MovieImdbDetailsDto getMovieImdbDetailsByMovieImdbId(long id) {
    MovieImdb movieImdb = movieImdbMapper.selectByPrimaryKey(id);
    return getMovieImdbDetailsByMovieImdb(movieImdb);
  }

  @Override
  public MovieImdbDetailsDto getMovieImdbDetailsByMovieDoubanId(long id) {
    movieImdbExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieImdb> movieImdbList = movieImdbMapper.selectByExample(movieImdbExample);
    return movieImdbList.size() != 1 ? null : getMovieImdbDetailsByMovieImdb(movieImdbList.get(0));
  }

  @Override
  public MovieImdbDetailsDto getMovieImdbDetailsByMovieImdb(MovieImdb movieImdb) {
    /** IMDB电影评分信息（包括烂番茄、MTC） */
    RateImdb rateImdb = rateImdbMapper.selectByPrimaryKey(movieImdb.getId());
    /** IMDB电影-类型列表 */
    movieImdbToTypeMovieExample.start().andIdMovieImdbEqualTo(movieImdb.getId());
    List<MovieImdbToTypeMovie> movieImdbToTypeMovieList =
        movieImdbToTypeMovieMapper.selectByExample(movieImdbToTypeMovieExample);
    /** 与IMDB电影相关的IMDB影人列表 */
    List<CelebrityImdbOfMovieImdbDo> celebrityImdbOfMovieImdbDoList =
        celebrityImdbMapperPlus.selectCelebrityImdbOfMovieImdbListByMovieImdbId(movieImdb.getId());
    return movieImdbDetailsDtoConverter.to(
        movieImdb, rateImdb, movieImdbToTypeMovieList, celebrityImdbOfMovieImdbDoList);
  }
}
