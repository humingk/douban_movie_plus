package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 场景地点类型
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypePlaceScene implements Serializable {
    /**
     * 场景地点类型ID
     */
    private Byte id;

    /**
     * 地点类型名称中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}