package org.humingk.movie.common.enumeration;

import lombok.AllArgsConstructor;

/**
 * oauth2默认客户端对应的资源
 *
 * @author humingk
 */
@AllArgsConstructor
public enum Resources {
    /**
     * 用户资源
     */
    USER("user"),
    /**
     * 电影资源
     */
    MOVIE("movie"),

    /**
     * 音乐资源
     */
    MUSIC("music");

    /**
     * 资源ID
     */
    public String id;
}
