package org.humingk.douban.service.impl;

import org.humingk.common.entity.MovieDouban;
import org.humingk.douban.service.SearchService;

import java.util.List;

/**
 * 搜索功能实现
 *
 * @author humingk
 */
public class SearchServiceImpl implements SearchService {
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
    @Override
    public List<MovieDouban> getMovieDoubanListByNameStart(String keyword, int offset, int limit) {
        return null;
    }

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
    @Override
    public List<MovieDouban> getMovieDoubanListByName(String keyword, int offset, int limit) {
        return null;
    }

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
    @Override
    public List<MovieDouban> getCelebrityDoubanListByNameStart(String keyword, int offset, int limit) {
        return null;
    }

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
    @Override
    public List<MovieDouban> getCelebrityDoubanListByName(String keyword, int offset, int limit) {
        return null;
    }
}
