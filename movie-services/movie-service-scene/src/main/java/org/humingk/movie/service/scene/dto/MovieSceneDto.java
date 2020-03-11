package org.humingk.movie.service.scene.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 场景电影
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieSceneDto implements Serializable {
    /**
     * 场景电影ID
     */
    private Long id;

    /**
     * 豆瓣电影ID 0-未匹配 1-已匹配
     */
    private Long idMovieDouban;

    /**
     * 场景电影中文名
     */
    private String nameZh;

    /**
     * 场景电影英文名
     */
    private String nameEn;

    /**
     * 上映时间 /year
     */
    private Short startYear;

    /**
     * 场景电影拍摄地点大致描述
     */
    private String description;

    /**
     * 场景电影地点分布图链接
     */
    private String urlMap;

    private static final long serialVersionUID = 1L;
}