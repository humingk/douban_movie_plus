package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影经典台词-豆瓣用户
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDoubanToClassicDouban implements Serializable {
    /**
     * 豆瓣用户ID 0-未登录用户
     */
    private String idUserDouban;

    /**
     * 豆瓣电影经典台词ID
     */
    private String idClassicDouban;

    /**
     * 用户中文名
     */
    private String nameZhUserDouban;

    /**
     * 豆瓣用户收录时间 /unix
     */
    private Long recordDatetime;

    /**
     * 豆瓣用户评价
     */
    private String description;

    private static final long serialVersionUID = 1L;
}