package org.humingk.douban.service;

import org.humingk.common.entity.MovieDouban;

import java.util.List;

/**
 * 搜索功能接口
 *
 * @author humingk
 */
public interface SearchService {

    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出电影的基本信息列表
     *
     * @param keyword
     * @param offset
     * @param limit
     * @return
     */
    List<MovieDouban> getMovieDoubanListByNameStart(String keyword, int offset, int limit);

    /**
     * 豆瓣电影搜索结果
     * <p>
     * 根据电影名称找出电影列表的基本信息列表
     *
     * @param keyword
     * @param offset
     * @param limit
     * @return
     */
    List<MovieDouban> getMovieDoubanListByName(String keyword, int offset, int limit);

    /**
     * 豆瓣影人搜索提示
     * <p>
     * 根据影人名称开头的字符串找出影人的基本信息列表
     *
     * @param keyword
     * @param offset
     * @param limit
     * @return
     */
    List<MovieDouban> getCelebrityDoubanListByNameStart(String keyword, int offset, int limit);

    /**
     * 豆瓣影人搜索结果
     * <p>
     * 根据影人名称找出影人列表的基本信息列表
     *
     * @param keyword
     * @param offset
     * @param limit
     * @return
     */
    List<MovieDouban> getCelebrityDoubanListByName(String keyword, int offset, int limit);


}
