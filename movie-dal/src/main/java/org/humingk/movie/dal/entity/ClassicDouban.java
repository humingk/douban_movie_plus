package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影经典台词
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassicDouban implements Serializable {
    /**
     * 豆瓣电影经典台词ID
     */
    private String id;

    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 经典台词内容
     */
    private String content;

    /**
     * 经典台词在影片中的出现时间 /m
     */
    private Integer happenTime;

    /**
     * 经典台词获得的赞同数
     */
    private Integer agreeVote;

    private static final long serialVersionUID = 1L;
}