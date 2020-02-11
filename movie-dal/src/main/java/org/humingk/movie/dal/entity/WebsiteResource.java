package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 电影资源网站
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteResource implements Serializable {
    /**
     * 电影资源网站ID ID<100-正版 ID>100-盗版
     */
    private Short id;

    /**
     * 网站中文名
     */
    private String nameZh;

    /**
     * 网站官网地址
     */
    private String websiteSrc;

    private static final long serialVersionUID = 1L;
}