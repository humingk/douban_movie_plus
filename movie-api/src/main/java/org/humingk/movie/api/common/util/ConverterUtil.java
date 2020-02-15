package org.humingk.movie.api.common.util;

import org.humingk.movie.common.entity.MovieConstant;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Pojo转换工具类
 *
 * <p>调用方式：
 *
 * <p>uses:class
 *
 * <p>qualifiedByName:ConverterUtil,unixTimestampToDate
 *
 * @author humingk
 */
@Component
@Named("ConverterUtil")
public class ConverterUtil {
  /**
   * Unix时间戳转换为yyyy-MM-dd
   *
   * @param unixTimestamp
   * @return
   */
  @Named("unixTimestampToDate")
  public String unixTimestampToDate(Long unixTimestamp) {
    return Instant.ofEpochSecond(unixTimestamp)
        .atZone(ZoneId.systemDefault())
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  /**
   * 获取豆瓣电影url
   *
   * @param id
   * @return
   */
  @Named("getUrlMovieDouban")
  public String getUrlMovieDouban(Long id) {
    return "https://movie.douban.com/subject/" + id;
  }

  /**
   * 获取豆瓣影人url
   *
   * @param id
   * @return
   */
  @Named("getUrlCelebrityDouban")
  public String getUrlCelebrityDouban(Long id) {
    return "https://movie.douban.com/celebrity/" + id;
  }

  /**
   * 获取IMDB电影ID
   *
   * @param id
   * @return
   */
  @Named("getIdMovieImdb")
  public String getIdMovieImdb(Long id) {
    return id == 0 || id == 1 ? "" : "tt" + String.format("%07d", id);
  }
  /**
   * 获取IMDB影人ID
   *
   * @param id
   * @return
   */
  @Named("getIdCelebrityImdb")
  public String getIdCelebrityImdb(Long id) {
    return id == 0 || id == 1 ? "" : "nm" + String.format("%07d", id);
  }

  /**
   * 获取IMDB电影url
   *
   * @param id
   * @return
   */
  @Named("getUrlMovieImdb")
  public String getUrlMovieImdb(Long id) {
    return "https://www.imdb.com/title/" + getIdMovieImdb(id);
  }
  /**
   * 获取IMDB影人url
   *
   * @param id
   * @return
   */
  @Named("getUrlCelebrityImdb")
  public String getUrlCelebrityImdb(Long id) {
    return "https://www.imdb.com/name/" + getIdCelebrityImdb(id);
  }

  /**
   * 获取影人职位中文名
   *
   * @param id
   * @return
   */
  @Named("getProfessionZh")
  public String getProfessionZh(Byte id) {
    return MovieConstant.PROFESSION_TYPE.get(id).get(0);
  }
}
