package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影-电影类型
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDoubanToTypeMovie implements Serializable {
    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 影片类型ID
     */
    private Short idTypeMovie;

    private static final long serialVersionUID = 1L;
}