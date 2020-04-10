package org.humingk.movie.dal.domain.douban;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.MovieDoubanToCelebrityDouban;

import java.io.Serializable;
import java.util.List;

/**
 * 与豆瓣电影相关的豆瓣影人
 *
 * <p>CelebrityDouban + MovieDoubanToCelebrityDouban
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelebrityDoubanOfMovieDoubanDo implements Serializable {
  private static final long serialVersionUID = 1L;

  // CelebrityDouban --------------------------------------

  /** 豆瓣影人ID */
  private Long id;

  /** IMDB影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityImdb;

  /** 豆瓣影人中文名 */
  private String nameZh;

  /** 豆瓣影人英文名 */
  private String nameOrigin;

  /** 性别 0-女 1-男 2-未知 */
  private Byte sex;

  /** 生日日期 /unix */
  private Long birthDate;

  /** 豆瓣影人海报ID */
  private String urlPortrait;

  /** 影人简介 */
  private String summary;

  // MovieDoubanToCelebrityDouban --------------------------------------

  /** 豆瓣电影-豆瓣影人 列表 */
  private List<MovieDoubanToCelebrityDouban> movieDoubanToCelebrityDoubanList;
}
