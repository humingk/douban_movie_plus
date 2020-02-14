package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 豆瓣电影-奖项
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDoubanToAwardMovie implements Serializable {
    /**
     * 豆瓣电影ID
     */
    private Long idMovieDouban;

    /**
     * 获奖奖项ID
     */
    private String idAwardMovie;

    /**
     * 获奖豆瓣影人ID
     */
    private Long idCelebrityDouban;

    /**
     * 奖项的类别中文名
     */
    private String typeAward;

    /**
     * 获奖奖项届数
     */
    private Short awardTh;

    /**
     * 是否被提名 0-仅提名未获奖 1-已提名且获奖
     */
    private Byte isNominated;

    private static final long serialVersionUID = 1L;
}