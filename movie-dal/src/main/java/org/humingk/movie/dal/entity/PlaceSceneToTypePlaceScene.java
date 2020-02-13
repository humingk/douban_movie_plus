package org.humingk.movie.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场景地点-场景地点类型
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceSceneToTypePlaceScene implements Serializable {
  private static final long serialVersionUID = 1L;
  /** 场景地点ID */
  private Long idPlaceScene;
  /** 场景地点类型ID */
  private Byte idTypePlaceScene;
}
