package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电影资源
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceMovie implements Serializable {
    /**
     * 电影资源ID
     */
    private Long id;

    /**
     * 豆瓣电影ID 0-未匹配 1-已匹配
     */
    private Long idMovieDouban;

    /**
     * IMDB电影ID 0-未匹配 1-已匹配
     */
    private Long idMovieImdb;

    /**
     * 电影资源网站ID ID<100-正版 ID>100-盗版
     */
    private Short idWebsiteResource;

    /**
     * 电影资源类型ID ID<100-在线  ID>100-离线
     */
    private Short idTypeResource;

    /**
     * 资源中文名
     */
    private String nameZh;

    /**
     * 电影年代 /year
     */
    private Short createYear;

    /**
     * 资源原始名
     */
    private String nameOrigin;

    /**
     * 资源链接
     */
    private String urlResource;

    private static final long serialVersionUID = 1L;
}