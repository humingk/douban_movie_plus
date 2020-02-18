package org.humingk.movie.service.douban.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.dal.domain.AwardOfMovieAndCelebrityDoubanDo;
import org.humingk.movie.dal.domain.MovieDoubanOfCelebrityDoubanDo;
import org.humingk.movie.dal.domain.SearchResultCelebrityDoubanDo;
import org.humingk.movie.dal.domain.SearchTipsCelebrityDoubanDo;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.AliasCelebrityDoubanMapper;
import org.humingk.movie.dal.mapper.auto.CelebrityDoubanMapper;
import org.humingk.movie.dal.mapper.auto.ImageCelebrityDoubanMapper;
import org.humingk.movie.dal.mapper.plus.MovieDouanToAwardMovieMapperPlus;
import org.humingk.movie.dal.mapper.plus.MovieDoubanMapperPlus;
import org.humingk.movie.service.douban.converter.celebrity.CelebrityDoubanDetailsDtoConverter;
import org.humingk.movie.service.douban.converter.celebrity.CelebrityDoubanDtoConverter;
import org.humingk.movie.service.douban.converter.celebrity.SearchResultCelebrityDoubanDtoConverter;
import org.humingk.movie.service.douban.converter.celebrity.SearchTipsCelebrityDoubanDtoConverter;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDetailsDto;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDto;
import org.humingk.movie.service.douban.dto.celebrity.SearchResultCelebrityDoubanDto;
import org.humingk.movie.service.douban.dto.celebrity.SearchTipsCelebrityDoubanDto;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** @author humingk */
@Service
// @RedisCache
public class CelebrityDoubanServiceImpl implements CelebrityDoubanService {
  /** mapper */
  @Autowired private CelebrityDoubanMapper celebrityDoubanMapper;

  @Autowired private MovieDoubanMapperPlus movieDoubanMapperPlus;
  @Autowired private AliasCelebrityDoubanMapper aliasCelebrityDoubanMapper;
  @Autowired private ImageCelebrityDoubanMapper imageCelebrityDoubanMapper;
  @Autowired private MovieDouanToAwardMovieMapperPlus movieDouanToAwardMovieMapperPlus;
  /** converter */
  @Autowired private CelebrityDoubanDtoConverter celebrityDoubanDtoConverter;

  @Autowired private CelebrityDoubanDetailsDtoConverter celebrityDoubanDetailsDtoConverter;

  @Autowired private SearchTipsCelebrityDoubanDtoConverter searchTipsCelebrityDoubanDtoConverter;

  @Autowired
  private SearchResultCelebrityDoubanDtoConverter searchResultCelebrityDoubanDtoConverter;
  /** example */
  @Autowired private AliasCelebrityDoubanExample aliasCelebrityDoubanExample;

  @Autowired private CelebrityDoubanExample celebrityDoubanExample;
  @Autowired private ImageCelebrityDoubanExample imageCelebrityDoubanExample;

  @Override
  public CelebrityDoubanDto getCelebrityDoubanByCelebrityDoubanId(long id) {
    return celebrityDoubanDtoConverter.to(celebrityDoubanMapper.selectByPrimaryKey(id));
  }

  @Override
  public CelebrityDoubanDetailsDto getCelebrityDoubanDetailsByCelebrityDoubanId(long id) {
    /** 豆瓣影人基础信息 */
    CelebrityDouban celebrityDouban = celebrityDoubanMapper.selectByPrimaryKey(id);
    /** 豆瓣影人别称列表 */
    aliasCelebrityDoubanExample.start().andIdCelebrityDoubanEqualTo(id);
    List<AliasCelebrityDouban> aliasCelebrityDoubanList =
        aliasCelebrityDoubanMapper.selectByExample(aliasCelebrityDoubanExample);
    /** 豆瓣影人图片列表 */
    imageCelebrityDoubanExample.start().andIdCelebrityDoubanEqualTo(id);
    List<ImageCelebrityDouban> imageCelebrityDoubanList =
        imageCelebrityDoubanMapper.selectByExample(imageCelebrityDoubanExample);
    /** 与豆瓣影人相关的豆瓣电影列表 */
    List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoList =
        movieDoubanMapperPlus.selectMovieDoubanOfCelebrityDoubanListByCelebrityDoubanId(id);
    /** 豆瓣影人-电影奖项 */
    List<AwardOfMovieAndCelebrityDoubanDo> awardOfMovieAndCelebrityDoubanDoList =
        movieDouanToAwardMovieMapperPlus.selectAwardOfMovieAndCelebrityListByCelebrityDoubanId(id);
    return celebrityDoubanDetailsDtoConverter.to(
        celebrityDouban,
        aliasCelebrityDoubanList,
        imageCelebrityDoubanList,
        movieDoubanOfCelebrityDoubanDoList,
        awardOfMovieAndCelebrityDoubanDoList);
  }

  @Override
  public List<SearchTipsCelebrityDoubanDto>
      getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
          String keyword, int offset, int limit) {
    List<SearchTipsCelebrityDoubanDo> searchTipsCelebrityDoubanDoList = new ArrayList<>();
    celebrityDoubanExample.start().andNameZhLike(keyword.trim() + "%");
    celebrityDoubanExample.or().andNameOriginLike(keyword.trim() + "%");
    PageHelper.offsetPage(offset, limit);
    for (CelebrityDouban celebrityDouban :
        celebrityDoubanMapper.selectByExample(celebrityDoubanExample)) {
      /** 豆瓣影人别称列表 */
      aliasCelebrityDoubanExample.start().andIdCelebrityDoubanEqualTo(celebrityDouban.getId());
      List<AliasCelebrityDouban> aliasCelebrityDoubanList =
          aliasCelebrityDoubanMapper.selectByExample(aliasCelebrityDoubanExample);
      searchTipsCelebrityDoubanDoList.add(
          new SearchTipsCelebrityDoubanDo(celebrityDouban, aliasCelebrityDoubanList));
    }
    return searchTipsCelebrityDoubanDtoConverter.toList(searchTipsCelebrityDoubanDoList);
  }

  @Override
  public List<SearchResultCelebrityDoubanDto>
      getSearchResultCelebrityDoubanListByCelebrityDoubanKeyword(
          String keyword, int offset, int limit) {
    List<SearchResultCelebrityDoubanDo> searchResultCelebrityDoubanDoList = new ArrayList<>();
    celebrityDoubanExample.start().andNameZhLike("%" + keyword.trim() + "%");
    celebrityDoubanExample.or().andNameOriginLike("%" + keyword.trim() + "%");
    PageHelper.offsetPage(offset, limit);
    for (CelebrityDouban celebrityDouban :
        celebrityDoubanMapper.selectByExample(celebrityDoubanExample)) {
      /** 豆瓣影人别称列表 */
      aliasCelebrityDoubanExample.start().andIdCelebrityDoubanEqualTo(celebrityDouban.getId());
      List<AliasCelebrityDouban> aliasCelebrityDoubanList =
          aliasCelebrityDoubanMapper.selectByExample(aliasCelebrityDoubanExample);
      /** 与豆瓣影人相关的豆瓣电影列表 */
      List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoList =
          movieDoubanMapperPlus.selectMovieDoubanOfCelebrityDoubanListByCelebrityDoubanId(
              celebrityDouban.getId());
      searchResultCelebrityDoubanDoList.add(
          new SearchResultCelebrityDoubanDo(
              celebrityDouban, aliasCelebrityDoubanList, movieDoubanOfCelebrityDoubanDoList));
    }
    return searchResultCelebrityDoubanDtoConverter.toList(searchResultCelebrityDoubanDoList);
  }
}
