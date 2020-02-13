package org.humingk.movie.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣用户-电影
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDoubanToMovieDouban implements Serializable {
    /**
     * 豆瓣用户ID
     */
    private String idUserDouban;

    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 用户对电影的评分
     */
    private BigDecimal score;

    /**
     * 是否想看 0-未标记 1-已想看
     */
    private Boolean isWish;

    /**
     * 是否看过 0-未标记 1-已看过
     */
    private Boolean isSeen;

    private static final long serialVersionUID = 1L;
}