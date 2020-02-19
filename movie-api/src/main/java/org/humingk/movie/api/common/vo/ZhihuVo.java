package org.humingk.movie.api.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.api.common.vo.zhihu.MovieZhihuVo;
import org.humingk.movie.api.common.vo.zhihu.QuestionZhihuVo;

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
public class ZhihuVo implements Serializable {
  /** 知乎话题 */
  private MovieZhihuVo topic;
  /** 知乎问题列表 */
  private List<QuestionZhihuVo> questionList;
}
