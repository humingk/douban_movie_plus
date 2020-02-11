package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户权限
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {
    /**
     * 用户权限ID
     */
    private Integer id;

    /**
     * 权限名称
     */
    private String nameZh;

    /**
     * 权限路径
     */
    private String pathSrc;

    /**
     * 权限描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}