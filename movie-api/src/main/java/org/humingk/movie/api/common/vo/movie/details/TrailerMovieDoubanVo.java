package org.humingk.movie.api.common.vo.movie.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 豆瓣电影预告片
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailerMovieDoubanVo implements Serializable {
  /** 豆瓣电影预告片ID */
  private Long id;

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 预告片豆瓣链接 */
  private String urlTrailer;

  /** 预告片mp4链接 */
  private String urlVideo;
}
