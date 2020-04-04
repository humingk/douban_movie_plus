package org.humingk.movie.service.douban.dto.celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.AliasCelebrityDouban;
import org.humingk.movie.dal.entity.CelebrityDouban;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣影人搜索提示
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTipsCelebrityDoubanDto implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 豆瓣影人基础信息 */
  private CelebrityDouban celebrityDouban;
  /** 豆瓣影人别称列表 */
  private List<AliasCelebrityDouban> aliasCelebrityDoubanList;
}
