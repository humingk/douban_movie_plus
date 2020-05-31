package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影经典台词-影人
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelebrityDoubanToClassicDouban implements Serializable {
    /**
     * 豆瓣影人ID
     */
    private Long idCelebrityDouban;

    /**
     * 豆瓣电影经典台词ID
     */
    private String idClassicDouban;

    /**
     * 豆瓣影人中文名
     */
    private String nameZhCelebrityDouban;

    private static final long serialVersionUID = 1L;
}