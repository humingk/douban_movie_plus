package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IMDB电影-影片类型
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieImdbToTypeMovie implements Serializable {
    /**
     * IMDB电影ID
     */
    private Long idMovieImdb;

    /**
     * 影片类型ID
     */
    private Short idTypeMovie;

    private static final long serialVersionUID = 1L;
}