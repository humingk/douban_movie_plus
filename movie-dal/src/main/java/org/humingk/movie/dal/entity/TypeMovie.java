package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电影类型
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeMovie implements Serializable {
    /**
     * 电影类型ID
     */
    private Short id;

    /**
     * 电影类型中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}