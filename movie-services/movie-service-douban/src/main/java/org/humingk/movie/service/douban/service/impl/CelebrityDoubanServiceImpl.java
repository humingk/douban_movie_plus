package org.humingk.movie.service.douban.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.domain.douban.AwardOfMovieAndCelebrityDoubanDo;
import org.humingk.movie.dal.domain.douban.MovieDoubanOfCelebrityDoubanDo;
import org.humingk.movie.dal.entity.*;
import org.humingk.movie.dal.mapper.auto.AliasCelebrityDoubanMapper;
import org.humingk.movie.dal.mapper.auto.CelebrityDoubanMapper;
import org.humingk.movie.dal.mapper.auto.ImageCelebrityDoubanMapper;
import org.humingk.movie.dal.mapper.plus.AliasCelebrityDoubanMapperPlus;
import org.humingk.movie.dal.mapper.plus.MovieDouanToAwardMovieMapperPlus;
import org.humingk.movie.dal.mapper.plus.MovieDoubanMapperPlus;
import org.humingk.movie.service.douban.converter.celebrity.CelebrityDoubanDetailsDtoConverter;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDetailsDto;
import org.humingk.movie.service.douban.dto.celebrity.SearchResultCelebrityDoubanDto;
import org.humingk.movie.service.douban.dto.celebrity.SearchTipsCelebrityDoubanDto;
import org.humingk.movie.service.douban.service.CelebrityDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** @author humingk */
@Service
@RedisCache
public class CelebrityDoubanServiceImpl implements CelebrityDoubanService {
  /** mapper */
  @Autowired private CelebrityDoubanMapper celebrityDoubanMapper;

  @Autowired private MovieDoubanMapperPlus movieDoubanMapperPlus;
  @Autowired private AliasCelebrityDoubanMapper aliasCelebrityDoubanMapper;
  @Autowired private ImageCelebrityDoubanMapper imageCelebrityDoubanMapper;
  @Autowired private MovieDouanToAwardMovieMapperPlus movieDouanToAwardMovieMapperPlus;
  @Autowired private AliasCelebrityDoubanMapperPlus aliasCelebrityDoubanMapperPlus;
  /** converter */
  @Autowired private CelebrityDoubanDetailsDtoConverter celebrityDoubanDetailsDtoConverter;

  /** example */
  @Autowired private AliasCelebrityDoubanExample aliasCelebrityDoubanExample;

  @Autowired private CelebrityDoubanExample celebrityDoubanExample;
  @Autowired private ImageCelebrityDoubanExample imageCelebrityDoubanExample;

  @Override
  public CelebrityDouban getCelebrityDoubanByCelebrityDoubanId(long id) {
    return celebrityDoubanMapper.selectByPrimaryKey(id);
  }

  @Override
  public CelebrityDoubanDetailsDto getCelebrityDoubanDetailsByCelebrityDoubanId(
      long id, int limit) {
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
    /** 与豆瓣影人相关的豆瓣电影列表 order by score */
    List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoListOrderByScore =
        movieDoubanMapperPlus.selectMovieDoubanOfCelebrityDoubanListByCelebrityDoubanId(
            id, limit, "score");
    /** 与豆瓣影人相关的豆瓣电影列表 order by start_year */
    List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoListOrderByStartYear =
        movieDoubanMapperPlus.selectMovieDoubanOfCelebrityDoubanListByCelebrityDoubanId(
            id, limit, "start_year");
    /** 豆瓣影人-电影奖项 */
    List<AwardOfMovieAndCelebrityDoubanDo> awardOfMovieAndCelebrityDoubanDoList =
        movieDouanToAwardMovieMapperPlus.selectAwardOfMovieAndCelebrityListByCelebrityDoubanId(id);
    return celebrityDoubanDetailsDtoConverter.to(
        celebrityDouban,
        aliasCelebrityDoubanList,
        imageCelebrityDoubanList,
        movieDoubanOfCelebrityDoubanDoListOrderByScore,
        movieDoubanOfCelebrityDoubanDoListOrderByStartYear,
        awardOfMovieAndCelebrityDoubanDoList);
  }

  @Override
  public List<CelebrityDouban> getCelebrityDoubanListByKeyword(
      String keyword, int offset, int limit) {
    celebrityDoubanExample.start().andNameZhLike(keyword.trim());
    celebrityDoubanExample.or().andNameOriginLike(keyword.trim());
    PageHelper.offsetPage(offset, limit);
    return celebrityDoubanMapper.selectByExample(celebrityDoubanExample);
  }

  @Override
  public List<CelebrityDouban> getCelebrityDoubanListByAliasKeyword(
      String keyword, int offset, int limit) {
    List<CelebrityDouban> celebrityDoubanList = new ArrayList<>();
    List<Long> idCelebrityDoubanList =
        aliasCelebrityDoubanMapperPlus.selectIdCelebrityDoubanListByKeyword(
            keyword.trim(), offset, limit);
    for (Long idCelebrityDouban : idCelebrityDoubanList) {
      celebrityDoubanList.add(celebrityDoubanMapper.selectByPrimaryKey(idCelebrityDouban));
    }
    return celebrityDoubanList;
  }

  @Override
  public List<SearchTipsCelebrityDoubanDto>
      getSearchTipsCelebrityDoubanListByCelebrityDoubanKeywordStart(
          String keyword, int offset, int limit) {
    List<SearchTipsCelebrityDoubanDto> searchTipsCelebrityDoubanDtoList = new ArrayList<>();
    List<CelebrityDouban> celebrityDoubanList =
        getCelebrityDoubanListByKeyword(keyword.trim() + "%", offset, limit);
    if (celebrityDoubanList.isEmpty()) {
      celebrityDoubanList =
          getCelebrityDoubanListByKeyword("%" + keyword.trim() + "%", offset, limit);
    }
    if (celebrityDoubanList.isEmpty()) {
      celebrityDoubanList =
          getCelebrityDoubanListByAliasKeyword(keyword.trim() + "%", offset, limit);
    }
    if (celebrityDoubanList.isEmpty()) {
      celebrityDoubanList =
          getCelebrityDoubanListByAliasKeyword("%" + keyword.trim() + "%", offset, limit);
    }
    for (CelebrityDouban celebrityDouban : celebrityDoubanList) {
      /** 豆瓣影人别称列表 */
      aliasCelebrityDoubanExample.start().andIdCelebrityDoubanEqualTo(celebrityDouban.getId());
      List<AliasCelebrityDouban> aliasCelebrityDoubanList =
          aliasCelebrityDoubanMapper.selectByExample(aliasCelebrityDoubanExample);
      searchTipsCelebrityDoubanDtoList.add(
          new SearchTipsCelebrityDoubanDto(celebrityDouban, aliasCelebrityDoubanList));
    }
    return searchTipsCelebrityDoubanDtoList;
  }

  @Override
  public List<SearchResultCelebrityDoubanDto>
      getSearchResultCelebrityDoubanListByCelebrityDoubanKeyword(
          String keyword, int offset, int limit) {
    List<SearchResultCelebrityDoubanDto> searchResultCelebrityDoubanDtoList = new ArrayList<>();
    List<CelebrityDouban> celebrityDoubanList =
        getCelebrityDoubanListByKeyword("%" + keyword.trim() + "%", offset, limit);
    if (celebrityDoubanList.isEmpty()) {
      celebrityDoubanList =
          getCelebrityDoubanListByAliasKeyword("%" + keyword.trim() + "%", offset, limit);
    }
    for (CelebrityDouban celebrityDouban : celebrityDoubanList) {
      /** 豆瓣影人别称列表 */
      aliasCelebrityDoubanExample.start().andIdCelebrityDoubanEqualTo(celebrityDouban.getId());
      List<AliasCelebrityDouban> aliasCelebrityDoubanList =
          aliasCelebrityDoubanMapper.selectByExample(aliasCelebrityDoubanExample);
      /** 与豆瓣影人相关的豆瓣电影列表 */
      List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoList =
          movieDoubanMapperPlus.selectMovieDoubanOfCelebrityDoubanListByCelebrityDoubanId(
              celebrityDouban.getId(), 5, "score");
      searchResultCelebrityDoubanDtoList.add(
          new SearchResultCelebrityDoubanDto(
              celebrityDouban, aliasCelebrityDoubanList, movieDoubanOfCelebrityDoubanDoList));
    }
    return searchResultCelebrityDoubanDtoList;
  }
}
