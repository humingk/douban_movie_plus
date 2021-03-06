package org.humingk.movie.service.imdb.service;

import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.service.imdb.dto.celebrity.CelebrityImdbDetailsDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/** @author humingk */
@Validated
public interface CelebrityImdbService {

  /**
   * 获取IMDB影人基础信息
   *
   * @param id IMDB影人ID
   * @return
   */
  @NotNull(message = "该IMDB影人ID暂无相关IMDB影人信息")
  CelebrityImdb getCelebrityImdbByCelebrityImdbId(long id);

  /**
   * 获取IMDB影人基础信息
   *
   * @param id 豆瓣影人ID
   * @return
   */
  @NotNull(message = "该豆瓣影人ID暂无相关IMDB影人信息")
  CelebrityImdb getCelebrityImdbByCelebrityDoubanId(long id);

  /**
   * 获取IMDB影人详细信息
   *
   * @param id IMDB影人ID
   * @param limit 相关电影限制数
   * @return
   */
  @NotNull(message = "该IMDB影人ID暂无相关IMDB影人信息")
  CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityImdbId(long id, int limit);

  /**
   * 获取IMDB影人详细信息
   *
   * @param id 豆瓣影人ID
   * @param limit 相关电影限制数
   * @return
   */
  @NotNull(message = "该豆瓣影人ID暂无相关IMDB影人信息")
  CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityDoubanId(long id, int limit);

  /**
   * 根据IMDB基础信息获取IMDB影人详细信息
   *
   * @param celebrityImdb IMDB基础信息
   * @param limit 相关电影限制数
   * @return
   */
  CelebrityImdbDetailsDto getCelebrityImdbDetailsByCelebrityImdb(
      CelebrityImdb celebrityImdb, int limit);
}
