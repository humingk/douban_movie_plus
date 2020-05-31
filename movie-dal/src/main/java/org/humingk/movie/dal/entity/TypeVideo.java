package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 影片种类
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeVideo implements Serializable {
    /**
     * 影片类型ID
     */
    private Byte id;

    /**
     * 影片类型中文名
     */
    private String nameZh;

    /**
     * 影片类型英文名
     */
    private String nameEn;

    private static final long serialVersionUID = 1L;
}