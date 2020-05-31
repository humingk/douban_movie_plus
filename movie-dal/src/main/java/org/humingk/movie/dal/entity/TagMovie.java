package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影标签
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagMovie implements Serializable {
    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 电影标签中文名
     */
    private String nameZh;

    private static final long serialVersionUID = 1L;
}