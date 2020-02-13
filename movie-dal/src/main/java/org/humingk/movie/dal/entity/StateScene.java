package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 州/省
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateScene implements Serializable {
    /**
     * 州/省ID
     */
    private Integer id;

    /**
     * 州中文名
     */
    private String nameZh;

    /**
     * 州英文名
     */
    private String nameEn;

    private static final long serialVersionUID = 1L;
}