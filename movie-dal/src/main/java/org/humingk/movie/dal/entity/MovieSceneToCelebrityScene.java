package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 场景电影-场景影人
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSceneToCelebrityScene implements Serializable {
    /**
     * 场景电影ID
     */
    private Long idMovieScene;

    /**
     * 场景影人ID
     */
    private Long idCelebrityScene;

    private static final long serialVersionUID = 1L;
}