package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 网易云音乐用户
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNetease implements Serializable {
    /**
     * 网易云音乐用户ID
     */
    private Long id;

    /**
     * 用户中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}