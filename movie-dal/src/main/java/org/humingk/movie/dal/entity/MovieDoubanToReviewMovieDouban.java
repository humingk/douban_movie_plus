package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影-影评
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDoubanToReviewMovieDouban implements Serializable {
    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 电影影评ID
     */
    private Long idReviewMovieDouban;

    private static final long serialVersionUID = 1L;
}