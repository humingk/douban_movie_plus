package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影-影人
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDoubanToCelebrityDouban implements Serializable {
    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 豆瓣影人ID
     */
    private Long idCelebrityDouban;

    /**
     * 该影人在该电影中的职位
     */
    private Byte idProfession;

    /**
     * 该影人在该电影中的演员排列顺序
     */
    private Short sort;

    private static final long serialVersionUID = 1L;
}