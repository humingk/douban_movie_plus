package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 洲
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContinentScene implements Serializable {
    /**
     * 洲ID
     */
    private Byte id;

    /**
     * 洲中文名
     */
    private String nameZh;

    /**
     * 洲英文名
     */
    private String nameEn;

    private static final long serialVersionUID = 1L;
}