package org.humingk.movie.service.douban;

import org.humingk.movie.service.common.entity.MovieDouban;

import java.util.List;

/**
 * @author humingk
 */
public interface SearchService {
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
