package org.humingk.movie.service.douban.dto.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.domain.AwardOfMovieAndCelebrityDoubanDo;
import org.humingk.movie.dal.domain.MovieDoubanOfCelebrityDoubanDo;
import org.humingk.movie.dal.entity.AliasCelebrityDouban;
import org.humingk.movie.dal.domain.ImageDoubanDo;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣影人详细信息
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CelebrityDoubanDetailsDto implements Serializable {
  private static final long serialVersionUID = 1L;

  /** 豆瓣影人基础信息 */
  private CelebrityDoubanDto celebrityDoubanDto;
  /** 豆瓣影人别称列表 */
  private List<AliasCelebrityDouban> aliasCelebrityDoubanList;
  /** 豆瓣图片列表 */
  private List<ImageDoubanDo> imageDoubanDoList;
  /** 与豆瓣影人相关的豆瓣电影列表 order by score */
  private List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoListOrderByScore;
  /** 与豆瓣影人相关的豆瓣电影列表 order by start_year */
  private List<MovieDoubanOfCelebrityDoubanDo> movieDoubanOfCelebrityDoubanDoListOrderByStartYear;
  /** 豆瓣影人-电影奖项 */
  private List<AwardOfMovieAndCelebrityDoubanDo> awardOfMovieAndCelebrityDoubanDoList;
}
