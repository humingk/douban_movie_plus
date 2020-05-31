package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 场景地点-场景地点类型
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceSceneToTypePlaceScene implements Serializable {
    /**
     * 场景地点ID
     */
    private Long idPlaceScene;

    /**
     * 场景地点类型ID
     */
    private Byte idTypePlaceScene;

    private static final long serialVersionUID = 1L;
}