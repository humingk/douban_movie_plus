package org.humingk.movie.service.zhihu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.MovieZhihu;
import org.humingk.movie.dal.entity.QuestionZhihu;

import java.io.Serializable;
import java.util.List;

/**
 * 知乎相关
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZhihuDto implements Serializable {
  /** 知乎话题 */
  private MovieZhihu movieZhihu;
  /** 知乎问题列表 */
  private List<QuestionZhihu> questionZhihuList;
}
