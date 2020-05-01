package org.humingk.movie.service.douban.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.domain.douban.*;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.*;
import org.humingk.movie.dal.mapper.plus.*;
import org.humingk.movie.service.douban.converter.movie.MovieDoubanDetailsDtoConverter;
import org.humingk.movie.service.douban.dto.movie.MovieDoubanDetailsDto;
import org.humingk.movie.service.douban.dto.movie.SearchResultMovieDoubanDto;
import org.humingk.movie.service.douban.dto.movie.SearchTipsMovieDoubanDto;
import org.humingk.movie.service.douban.service.MovieDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** @author humingk */
@Service
@RedisCache
public class MovieDoubanServiceImpl implements MovieDoubanService {

  /** converter */
  @Autowired private MovieDoubanDetailsDtoConverter movieDoubanDetailsDtoConverter;
  /** example */
  @Autowired private AliasMovieDoubanExample aliasMovieDoubanExample;

  @Autowired private MovieDoubanExample movieDoubanExample;
  @Autowired private MovieDoubanToTypeMovieExample movieDoubanToTypeMovieExample;
  @Autowired private TagMovieExample tagMovieExample;
  @Autowired private MovieDoubanToCelebrityDoubanExample movieDoubanToCelebrityDoubanExample;
  @Autowired private TrailerMovieDoubanExample trailerMovieDoubanExample;
  @Autowired private ImageMovieDoubanExample imageMovieDoubanExample;
  @Autowired private ClassicDoubanExample classicDoubanExample;
  /** mapper */
  @Autowired private AliasMovieDoubanMapper aliasMovieDoubanMapper;

  @Autowired private MovieDoubanToTypeMovieMapper movieDoubanToTypeMovieMapper;
  @Autowired private TagMovieMapper tagMovieMapper;
  @Autowired private CelebrityDoubanMapperPlus celebrityDoubanMapperPlus;
  @Autowired private TrailerMovieDoubanMapper trailerMovieDoubanMapper;
  @Autowired private ImageMovieDoubanMapper imageMovieDoubanMapper;
  @Autowired private ClassicDoubanMapper classicDoubanMapper;
  @Autowired private ReviewMovieDoubanMapperPlus reviewMovieDoubanMapperPlus;
  @Autowired private MovieDoubanMapper movieDoubanMapper;
  @Autowired private RateMovieDoubanMapper rateMovieDoubanMapper;
  @Autowired private MovieDouanToAwardMovieMapperPlus moviedouanToAwardMovieMapperPlus;
  @Autowired private CommentMovieDoubanMapperPlus commentMovieDoubanMapperPlus;
  @Autowired private ClassicDoubanMapperPlus classicDoubanMapperPlus;

  @Override
  public MovieDouban getMovieDoubanByMovieDoubanId(long id) {
    return movieDoubanMapper.selectByPrimaryKey(id);
  }

  @Override
  public RateMovieDouban getRateMovieDoubanByMovieDoubanId(long id) {
    return rateMovieDoubanMapper.selectByPrimaryKey(id);
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
    List<CelebrityDoubanOfMovieDoubanDo> celebrityDoubanOfMovieDoubanDoList =
        celebrityDoubanMapperPlus.selectCelebrityDoubanOfMovieDoubanListByMovieDoubanId(id);
    /** 豆瓣电影预告片列表 */
    trailerMovieDoubanExample.start().andIdMovieDoubanEqualTo(id);
    List<TrailerMovieDouban> trailerMovieDoubanList =
        trailerMovieDoubanMapper.selectByExample(trailerMovieDoubanExample);
    /** 豆瓣电影图片列表 */
    imageMovieDoubanExample.start().andIdMovieDoubanEqualTo(id);
    imageMovieDoubanExample.setOrderByClause("sort");
    List<ImageMovieDouban> imageMovieDoubanList =
        imageMovieDoubanMapper.selectByExample(imageMovieDoubanExample);
    /** 豆瓣电影经典台词列表 */
    List<ClassicOfMovieDoubanDo> classicOfMovieDoubanDoList =
        classicDoubanMapperPlus.selectClassicOfMovieDoubanDoListByMovieDoubanId(id);
    /** 豆瓣电影热门评论列表 */
    List<CommentOfMovieDoubanDo> commentOfMovieDoubanDoList =
        commentMovieDoubanMapperPlus.selectCommentOfMovieDoubanListByMovieDoubanId(id);
    /** 豆瓣电影-热门影评列表 */
    List<ReviewOfMovieDoubanDo> reviewOfMovieDoubanDoList =
        reviewMovieDoubanMapperPlus.selectReviewOfMovieDoubanListByMovieDoubanId(id);
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
        classicOfMovieDoubanDoList,
        commentOfMovieDoubanDoList,
        reviewOfMovieDoubanDoList,
        awardOfMovieAndCelebrityDoubanDoList);
  }

  @Override
  public List<SearchTipsMovieDoubanDto> getSearchTipsMovieDoubanListByMovieDoubanKeywordStart(
      String keyword, int offset, int limit) {
    List<SearchTipsMovieDoubanDto> searchTipsMovieDoubanDtoList = new ArrayList<>();
    movieDoubanExample.start().andNameZhLike(keyword.trim() + "%");
    movieDoubanExample.or().andNameOriginLike(keyword.trim() + "%");
    PageHelper.offsetPage(offset, limit);
    for (MovieDouban movieDouban : movieDoubanMapper.selectByExample(movieDoubanExample)) {
      RateMovieDouban rateMovieDouban =
          rateMovieDoubanMapper.selectByPrimaryKey(movieDouban.getId());
      aliasMovieDoubanExample.start().andIdMovieDoubanEqualTo(movieDouban.getId());
      List<AliasMovieDouban> aliasMovieDoubanList =
          aliasMovieDoubanMapper.selectByExample(aliasMovieDoubanExample);
      searchTipsMovieDoubanDtoList.add(
          new SearchTipsMovieDoubanDto(movieDouban, rateMovieDouban, aliasMovieDoubanList));
    }
    return searchTipsMovieDoubanDtoList;
  }

  @Override
  public List<SearchResultMovieDoubanDto> getSearchResultMovieDoubanListByMovieDoubanKeyword(
      String keyword, int offset, int limit) {
    List<SearchResultMovieDoubanDto> searchResultMovieDoubanDtoList = new ArrayList<>();
    movieDoubanExample.start().andNameZhLike("%" + keyword.trim() + "%");
    movieDoubanExample.or().andNameOriginLike("%" + keyword.trim() + "%");
    PageHelper.offsetPage(offset, limit);
    for (MovieDouban movieDouban : movieDoubanMapper.selectByExample(movieDoubanExample)) {
      RateMovieDouban rateMovieDouban =
          rateMovieDoubanMapper.selectByPrimaryKey(movieDouban.getId());
      aliasMovieDoubanExample.start().andIdMovieDoubanEqualTo(movieDouban.getId());
      List<AliasMovieDouban> aliasMovieDoubanList =
          aliasMovieDoubanMapper.selectByExample(aliasMovieDoubanExample);
      movieDoubanToTypeMovieExample.start().andIdMovieDoubanEqualTo(movieDouban.getId());
      List<MovieDoubanToTypeMovie> movieDoubanToTypeMovieList =
          movieDoubanToTypeMovieMapper.selectByExample(movieDoubanToTypeMovieExample);
      List<CelebrityDoubanOfMovieDoubanDo> celebrityDoubanOfMovieDoubanDoList =
          celebrityDoubanMapperPlus.selectCelebrityDoubanOfMovieDoubanListByMovieDoubanId(
              movieDouban.getId());
      searchResultMovieDoubanDtoList.add(
          new SearchResultMovieDoubanDto(
              movieDouban,
              rateMovieDouban,
              aliasMovieDoubanList,
              movieDoubanToTypeMovieList,
              celebrityDoubanOfMovieDoubanDoList));
    }
    return searchResultMovieDoubanDtoList;
  }
}
