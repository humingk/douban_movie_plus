package org.humingk.movie.service.douban.service.impl;

import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.*;
import org.humingk.movie.service.douban.common.converter.MovieDoubanDetailsDtoConverter;
import org.humingk.movie.service.douban.common.converter.MovieDoubanDtoConverter;
import org.humingk.movie.service.douban.common.dto.MovieDoubanDetailsDto;
import org.humingk.movie.service.douban.common.dto.MovieDoubanDto;
import org.humingk.movie.service.douban.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
@RedisCache
public class MovieServiceImpl implements MovieService {

  /** converter */
  @Autowired private MovieDoubanDtoConverter movieDoubanDtoConverter;

  @Autowired private MovieDoubanDetailsDtoConverter movieDoubanDetailsDtoConverter;

  /** example */
  @Autowired private AliasMovieDoubanExample aliasMovieDoubanExample;

  @Autowired private MovieDoubanToTypeMovieExample movieDoubanToTypeMovieExample;
  @Autowired private TagMovieExample tagMovieExample;
  @Autowired private MovieDoubanToCelebrityDoubanExample movieDoubanToCelebrityDoubanExample;
  @Autowired private TrailerMovieDoubanExample trailerMovieDoubanExample;
  @Autowired private ImageMovieDoubanExample imageMovieDoubanExample;
  @Autowired private ClassicDoubanExample classicDoubanExample;
  @Autowired private CommentMovieDoubanExample commentMovieDoubanExample;
  @Autowired private MovieDoubanToReviewMovieDoubanExample movieDoubanToReviewMovieDoubanExample;
  @Autowired private MovieDoubanToAwardMovieExample movieDoubanToAwardMovieExample;
  /** mapper */
  @Autowired private AliasMovieDoubanMapper aliasMovieDoubanMapper;

  @Autowired private MovieDoubanToTypeMovieMapper movieDoubanToTypeMovieMapper;
  @Autowired private TagMovieMapper tagMovieMapper;
  @Autowired private MovieDoubanToCelebrityDoubanMapper movieDoubanToCelebrityDoubanMapper;
  @Autowired private TrailerMovieDoubanMapper trailerMovieDoubanMapper;
  @Autowired private ImageMovieDoubanMapper imageMovieDoubanMapper;
  @Autowired private ClassicDoubanMapper classicDoubanMapper;
  @Autowired private CommentMovieDoubanMapper commentMovieDoubanMapper;
  @Autowired private MovieDoubanToReviewMovieDoubanMapper movieDoubanToReviewMovieDoubanMapper;
  @Autowired private MovieDoubanToAwardMovieMapper movieDoubanToAwardMovieMapper;
  @Autowired private MovieDoubanMapper movieDoubanMapper;
  @Autowired private RateMovieDoubanMapper rateMovieDoubanMapper;

  @Override
  public MovieDoubanDto getMovieDoubanByMovieDoubanId(long id) {
    return movieDoubanDtoConverter.to(movieDoubanMapper.selectByPrimaryKey(id));
  }

  @Override
  public MovieDoubanDetailsDto getMovieDoubanDetailsByMovieDoubanId(long id) {
    /** 豆瓣电影基础信息 */
    MovieDouban movieDouban = movieDoubanMapper.selectByPrimaryKey(id);
    /** 豆瓣电影评分信息 */
    RateMovieDouban rateMovieDouban = rateMovieDoubanMapper.selectByPrimaryKey(id);
    /** 豆瓣电影别名列表 */
    aliasMovieDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<AliasMovieDouban> aliasMovieDoubanList =
        aliasMovieDoubanMapper.selectByExample(aliasMovieDoubanExample);
    /** 豆瓣电影-类型列表 */
    movieDoubanToTypeMovieExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList =
        movieDoubanToTypeMovieMapper.selectByExample(movieDoubanToTypeMovieExample);
    /** 豆瓣电影标签列表 */
    tagMovieExample.start().andIdMovieDoubanEqualTo(id);
    List<TagMovie> tagMovieList = tagMovieMapper.selectByExample(tagMovieExample);
    /** 豆瓣电影-影人列表 */
    movieDoubanToCelebrityDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieDoubanToCelebrityDouban> movieDoubanToCelebrityDoubanList =
        movieDoubanToCelebrityDoubanMapper.selectByExample(movieDoubanToCelebrityDoubanExample);
    /** 豆瓣电影预告片列表 */
    trailerMovieDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<TrailerMovieDouban> trailerMovieDoubanList =
        trailerMovieDoubanMapper.selectByExample(trailerMovieDoubanExample);
    /** 豆瓣电影图片列表 */
    imageMovieDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<ImageMovieDouban> imageMovieDoubanList =
        imageMovieDoubanMapper.selectByExample(imageMovieDoubanExample);
    /** 豆瓣电影经典台词列表 */
    classicDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<ClassicDouban> classicDoubanList =
        classicDoubanMapper.selectByExample(classicDoubanExample);
    /** 豆瓣电影热门评论列表 */
    commentMovieDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<CommentMovieDouban> commentMovieDoubanList =
        commentMovieDoubanMapper.selectByExample(commentMovieDoubanExample);
    /** 豆瓣电影-热门影评列表 */
    movieDoubanToReviewMovieDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieDoubanToReviewMovieDouban> movieDoubanToReviewMovieDoubanList =
        movieDoubanToReviewMovieDoubanMapper.selectByExample(movieDoubanToReviewMovieDoubanExample);
    /** 豆瓣电影-奖项列表 */
    movieDoubanToAwardMovieExample.start().andIdMovieDoubanEqualTo(id);
    List<MovieDoubanToAwardMovie> movieDoubanToAwardMovieList =
        movieDoubanToAwardMovieMapper.selectByExample(movieDoubanToAwardMovieExample);
    // 转换为dto
    return movieDoubanDetailsDtoConverter.to(
        movieDouban,
        rateMovieDouban,
        aliasMovieDoubanList,
        movieDoubanToTypeMovieList,
        tagMovieList,
        movieDoubanToCelebrityDoubanList,
        trailerMovieDoubanList,
        imageMovieDoubanList,
        classicDoubanList,
        commentMovieDoubanList,
        movieDoubanToReviewMovieDoubanList,
        movieDoubanToAwardMovieList);
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
    //    example.or().andIdEqualTo(id);
    return trailerMovieDoubanMapper.selectByExample(example);
  }
}
