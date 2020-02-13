package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 知乎问题
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionZhihu implements Serializable {
    /**
     * 知乎问题ID
     */
    private Long id;

    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 知乎问题中文名
     */
    private String nameZh;

    /**
     * 回答数 0-默认 1-文章
     */
    private Integer answerNum;

    private static final long serialVersionUID = 1L;
}