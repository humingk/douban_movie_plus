package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IMDB影人
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelebrityImdb implements Serializable {
    /**
     * IMDB影人ID nm++00xxx(7)
     */
    private Long id;

    /**
     * IMDB影人英文名
     */
    private String nameEn;

    /**
     * 出生年份 /year
     */
    private Short birthYear;

    /**
     * 豆瓣影人ID 0-未匹配 1-已匹配
     */
    private Long idCelebrityDouban;

    private static final long serialVersionUID = 1L;
}