package org.humingk.movie.service.douban.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.common.entity.MovieDouban;
import org.humingk.common.entity.MovieDoubanExample;
import org.humingk.common.mapper.MovieDoubanMapper;
import org.humingk.movie.service.douban.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author humingk
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private MovieDoubanMapper movieDoubanMapper;

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
        MovieDoubanExample example = new MovieDoubanExample();
        example.or().andNameZhLike(keyword + "%");
        PageHelper.startPage(offset, limit);
        return movieDoubanMapper.selectByExample(example);
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
