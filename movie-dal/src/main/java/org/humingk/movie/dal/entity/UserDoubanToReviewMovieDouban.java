package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣用户-豆瓣影评
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDoubanToReviewMovieDouban implements Serializable {
    /**
     * 豆瓣用户ID
     */
    private String idUserDouban;

    /**
     * 豆瓣影评ID
     */
    private Long idReviewMovieDouban;

    private static final long serialVersionUID = 1L;
}