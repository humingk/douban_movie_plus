package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电影别名
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AliasMovieDouban implements Serializable {
    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 电影别名
     */
    private String nameAlias;

    private static final long serialVersionUID = 1L;
}