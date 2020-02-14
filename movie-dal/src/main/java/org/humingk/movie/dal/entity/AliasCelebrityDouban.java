package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 影人别名
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliasCelebrityDouban implements Serializable {
    /**
     * 豆瓣影人ID
     */
    private Long idCelebrityDouban;

    /**
     * 豆瓣影人别称
     */
    private String nameAlias;

    /**
     * 是否为昵称 0-本名 1-昵称
     */
    private Byte isNikename;

    private static final long serialVersionUID = 1L;
}