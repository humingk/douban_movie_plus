package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影短评
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentMovieDouban implements Serializable {
    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 豆瓣用户ID
     */
    private String idUserDouban;

    /**
     * 投票数
     */
    private Long agreeVote;

    /**
     * 短评日期 /unix
     */
    private Long createDate;

    /**
     * 短评内容
     */
    private String content;

    private static final long serialVersionUID = 1L;
}