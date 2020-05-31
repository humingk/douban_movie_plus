package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城市
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityScene implements Serializable {
    /**
     * 城市ID
     */
    private Integer id;

    /**
     * 城市中文名
     */
    private String nameZh;

    /**
     * 城市英文名
     */
    private String nameEn;

    private static final long serialVersionUID = 1L;
}