package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电影奖项
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AwardMovie implements Serializable {
    /**
     * 电影奖项ID
     */
    private String id;

    /**
     * 电影奖项中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}