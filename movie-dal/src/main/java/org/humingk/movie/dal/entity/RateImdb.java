package org.humingk.movie.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IMDB电影评分
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateImdb implements Serializable {
    /**
     * IMDB电影ID tt+00xxx(7)
     */
    private Long id;

    /**
     * IMDB评分
     */
    private BigDecimal imdbScore;

    /**
     * IMDB评分人数
     */
    private Integer imdbVote;

    /**
     * 烂番茄新鲜度
     */
    private BigDecimal tomatoScore;

    /**
     * MTC评分
     */
    private BigDecimal mtcScore;

    private static final long serialVersionUID = 1L;
}