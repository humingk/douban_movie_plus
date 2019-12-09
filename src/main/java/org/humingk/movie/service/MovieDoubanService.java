package org.humingk.movie.service;

import org.humingk.movie.entity.MovieDouban;

import java.util.List;

/**
 * 豆瓣电影业务逻辑接口
 *
 * @author humingk
 */
public interface MovieDoubanService {
    /**
     * 豆瓣电影
     * 根据电影名称开头的字符串找出电影的基本资料
     *
     * @param keyword
     * @param offset
     * @param limit
     * @return
     */
    List<MovieDouban> getMovieDoubanListByNameStart(String keyword, int offset, int limit);
}
