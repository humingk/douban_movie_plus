package org.humingk.movie.service.douban.service.impl;

import org.humingk.movie.dal.domain.AwardOfMovieAndCelebrityDoubanDo;
import org.humingk.movie.dal.domain.CelebrityDoubanOfMovieDoubanDo;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.*;
import org.humingk.movie.dal.mapper.plus.CelebrityDoubanMapperPlus;
import org.humingk.movie.dal.mapper.plus.MovieDouanToAwardMovieMapperPlus;
import org.humingk.movie.dal.mapper.plus.ReviewMovieDoubanMapperPlus;
import org.humingk.movie.service.douban.common.converter.movie.MovieDoubanDetailsDtoConverter;
import org.humingk.movie.service.douban.common.converter.movie.MovieDoubanDtoConverter;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDetailsDto;
import org.humingk.movie.service.douban.common.dto.movie.MovieDoubanDto;
import org.humingk.movie.service.douban.service.MovieDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author humingk */
@Service
// @RedisCache
public class MovieDoubanServiceImpl implements MovieDoubanService {

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
  /** mapper */
  @Autowired private AliasMovieDoubanMapper aliasMovieDoubanMapper;

  @Autowired private MovieDoubanToTypeMovieMapper movieDoubanToTypeMovieMapper;
  @Autowired private TagMovieMapper tagMovieMapper;
  @Autowired private CelebrityDoubanMapperPlus celebrityDoubanMapperPlus;
  @Autowired private TrailerMovieDoubanMapper trailerMovieDoubanMapper;
  @Autowired private ImageMovieDoubanMapper imageMovieDoubanMapper;
  @Autowired private ClassicDoubanMapper classicDoubanMapper;
  @Autowired private CommentMovieDoubanMapper commentMovieDoubanMapper;
  @Autowired private ReviewMovieDoubanMapperPlus reviewMovieDoubanMapperPlus;
  @Autowired private MovieDoubanMapper movieDoubanMapper;
  @Autowired private RateMovieDoubanMapper rateMovieDoubanMapper;
  @Autowired private MovieDouanToAwardMovieMapperPlus moviedouanToAwardMovieMapperPlus;

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
    /** 豆瓣电影影人列表 */
    movieDoubanToCelebrityDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<CelebrityDoubanOfMovieDoubanDo> celebrityDoubanOfMovieDoubanDoList =
        celebrityDoubanMapperPlus.selectCelebrityDoubanOfMovieDoubanListByMovieDoubanId(id);
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
    List<ReviewMovieDouban> reviewMovieDoubanList =
        reviewMovieDoubanMapperPlus.selectReviewMovieDoubanListByMovieDoubanId(id);
    /** 豆瓣电影-奖项列表 */
    List<AwardOfMovieAndCelebrityDoubanDo> awardOfMovieAndCelebrityDoubanDoList =
        moviedouanToAwardMovieMapperPlus.selectAwardOfMovieAndCelebrityListByMovieDoubanId(id);
    // 转换为dto
    return movieDoubanDetailsDtoConverter.to(
        movieDouban,
        rateMovieDouban,
        aliasMovieDoubanList,
        movieDoubanToTypeMovieList,
        tagMovieList,
        celebrityDoubanOfMovieDoubanDoList,
        trailerMovieDoubanList,
        imageMovieDoubanList,
        classicDoubanList,
        commentMovieDoubanList,
        reviewMovieDoubanList,
        awardOfMovieAndCelebrityDoubanDoList);
  }
}
