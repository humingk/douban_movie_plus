package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 国家
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryScene implements Serializable {
    /**
     * 国家ID
     */
    private Short id;

    /**
     * 国家中文名
     */
    private String nameZh;

    /**
     * 国家英文名
     */
    private String nameEn;

    private static final long serialVersionUID = 1L;
}