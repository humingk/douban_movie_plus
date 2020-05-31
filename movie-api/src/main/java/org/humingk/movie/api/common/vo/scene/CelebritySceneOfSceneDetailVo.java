package org.humingk.movie.api.common.vo.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场景详情的相关场景影人
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelebritySceneOfSceneDetailVo implements Serializable {

  /** 场景影人ID */
  private Long id;

  /** 豆瓣影人ID 0-未匹配 1-已匹配 */
  private Long idCelebrityDouban;

  /** 豆瓣影人链接 */
  private String urlCelebrityDouban;
  /** 场景影人中文名 */
  private String nameZh;

  /** 场景影人英文名 */
  private String nameEn;

  /** 对应的场景详情ID */
  private Long idSceneDetail;

  private static final long serialVersionUID = 1L;
}
