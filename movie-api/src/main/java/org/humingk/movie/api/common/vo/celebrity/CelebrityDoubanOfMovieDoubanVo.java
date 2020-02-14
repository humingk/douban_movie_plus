package org.humingk.movie.api.common.vo.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 与豆瓣电影相关的豆瓣影人
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDoubanOfMovieDoubanVo implements Serializable {

  /** 豆瓣影人ID */
  private Long id;

  /** 豆瓣影人链接 */
  private String urlCelebrityDouban;

  /** IMDB影人ID */
  private String idCelebrityImdb;

  /** IMDB影人链接 */
  private String urlCelebrityImdb;

  /** 豆瓣影人中文名 */
  private String nameZh;

  /** 豆瓣影人英文名 */
  private String nameOrigin;

  /** 性别 */
  private String sex;

  /** 生日日期 */
  private String birthDate;

  /** 豆瓣影人海报链接 */
  private String urlPortrait;

  /** 影人简介 */
  private String summary;

  /** 该影人在该电影中的职位 */
  private String profession;

  /** 该影人在该电影中的演员排列顺序 */
  private Short sort;
}
