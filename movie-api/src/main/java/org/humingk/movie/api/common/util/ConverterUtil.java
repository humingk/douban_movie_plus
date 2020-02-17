package org.humingk.movie.api.common.util;

import org.apache.commons.lang.time.DateFormatUtils;
import org.humingk.movie.common.entity.MovieConstant;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
@Named("util")
public class ConverterUtil {
  /**
   * Unix时间戳转换为yyyy-MM-dd
   *
   * @param unixTimestamp
   * @return
   */
  @Named("unixTimestamp")
  public String unixTimestamp(Long unixTimestamp) {
    return DateFormatUtils.format(unixTimestamp, "yyyy-MM-dd");
  }

  /**
   * 获取豆瓣电影url
   *
   * @param id
   * @return
   */
  @Named("urlMovieDouban")
  public String urlMovieDouban(Long id) {
    return "https://movie.douban.com/subject/" + id;
  }

  /**
   * 获取豆瓣影人url
   *
   * @param id
   * @return
   */
  @Named("urlCelebrityDouban")
  public String urlCelebrityDouban(Long id) {
    return "https://movie.douban.com/celebrity/" + id;
  }

  /**
   * 获取IMDB电影ID
   *
   * @param id
   * @return
   */
  @Named("idMovieImdb")
  public String idMovieImdb(Long id) {
    return id == 0 || id == 1 ? "" : "tt" + String.format("%07d", id);
  }
  /**
   * 获取IMDB影人ID
   *
   * @param id
   * @return
   */
  @Named("idCelebrityImdb")
  public String idCelebrityImdb(Long id) {
    return id == 0 || id == 1 ? "" : "nm" + String.format("%07d", id);
  }

  /**
   * 获取IMDB电影url
   *
   * @param id
   * @return
   */
  @Named("urlMovieImdb")
  public String urlMovieImdb(Long id) {
    return "https://www.imdb.com/title/" + idMovieImdb(id);
  }
  /**
   * 获取IMDB影人url
   *
   * @param id
   * @return
   */
  @Named("urlCelebrityImdb")
  public String urlCelebrityImdb(Long id) {
    return "https://www.imdb.com/name/" + idCelebrityImdb(id);
  }

  /**
   * 获取影人职位中文名
   *
   * @param id
   * @return
   */
  @Named("profession")
  public String professionZh(Byte id) {
    return MovieConstant.PROFESSION_TYPE.get(id).get(0);
  }

  /**
   * 获取性别中文名
   *
   * @param sex
   * @return
   */
  @Named("sex")
  public String sex(Byte sex) {
    return sex == 0 ? "女" : (sex == 1 ? "男" : "");
  }

  /**
   * 获取豆瓣电影海报链接
   *
   * @param id 豆瓣电影ID
   * @return
   */
  @Named("urlPoster")
  public String urlMoviePoster(Long id) {
    return "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p" + id + ".webp";
  }

  /**
   * 获取IMDB电影海报链接
   *
   * @param url IMDB电影海报部分链接
   * @return
   */
  @Named("urlPosterImdb")
  public String urlPosterImdb(String url) {
    return "https://m.media-amazon.com/images/M/" + url;
  }

  /**
   * 获取豆瓣影人头像链接
   *
   * @param id
   * @return
   */
  @Named("urlPortrait")
  public String urlCelebrityPortrait(Long id) {
    return "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p" + id + ".webp";
  }

  /**
   * 获取影片类型
   *
   * @param idTypeVideo
   * @return
   */
  @Named("typeVideo")
  public String typeVideo(Byte idTypeVideo) {
    return MovieConstant.VIDEO_TYPE.get(idTypeVideo).get(0);
  }

  /**
   * 获取豆瓣电影别名列表
   *
   * @param aliasMovieDoubanList
   * @return
   */
  @Named("aliasList")
  public List<String> aliasList(List<AliasMovieDouban> aliasMovieDoubanList) {
    return aliasMovieDoubanList.stream()
        .map(AliasMovieDouban::getNameAlias)
        .collect(Collectors.toList());
  }
}
