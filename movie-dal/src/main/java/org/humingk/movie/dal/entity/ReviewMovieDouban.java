package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影影评
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewMovieDouban implements Serializable {
    /**
     * 豆瓣电影影评ID
     */
    private Long id;

    /**
     * 赞同数
     */
    private Integer agreeVote;

    /**
     * 反对数
     */
    private Integer againstVote;

    /**
     * 影评日期时间 /unix
     */
    private Long createDatetime;

    /**
     * 影评标题
     */
    private String title;

    /**
     * 影评内容
     */
    private String content;

    private static final long serialVersionUID = 1L;
}