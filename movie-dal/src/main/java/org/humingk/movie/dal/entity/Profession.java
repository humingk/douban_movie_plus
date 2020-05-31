package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 影人职业
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profession implements Serializable {
    /**
     * 影人职业ID
     */
    private Byte id;

    /**
     * 职业中文名
     */
    private String nameZh;

    /**
     * 职业英文名
     */
    private String nameEn;

    private static final long serialVersionUID = 1L;
}