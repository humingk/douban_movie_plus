package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣用户
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDouban implements Serializable {
    /**
     * 豆瓣用户ID
     */
    private String id;

    /**
     * 豆瓣名字中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}