package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * cccc
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeResource implements Serializable {
    /**
     * 电影资源类型ID ID<100-在线  ID>100-离线
     */
    private Short id;

    /**
     * 资源类型中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}