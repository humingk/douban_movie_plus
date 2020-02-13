package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影图片
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageMovieDouban implements Serializable {
    /**
     * 豆瓣电影图片ID
     */
    private Long id;

    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 序号
     */
    private Byte sort;

    /**
     * 长 /px
     */
    private Integer length;

    /**
     * 宽 /px
     */
    private Integer width;

    private static final long serialVersionUID = 1L;
}