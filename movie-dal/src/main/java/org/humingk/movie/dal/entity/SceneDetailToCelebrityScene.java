package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 场景详情-场景影人
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SceneDetailToCelebrityScene implements Serializable {
    /**
     * 场景详情ID
     */
    private Long idSceneDetail;

    /**
     * 场景影人ID
     */
    private Long idCelebrityScene;

    private static final long serialVersionUID = 1L;
}