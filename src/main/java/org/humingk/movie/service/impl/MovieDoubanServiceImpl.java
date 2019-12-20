package org.humingk.movie.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.entity.MovieDouban;
import org.humingk.movie.entity.MovieDoubanExample;
import org.humingk.movie.mapper.MovieDoubanMapper;
import org.humingk.movie.service.MovieDoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author humingk
 */
@Service
@CacheConfig(cacheNames = "movie")
public class MovieDoubanServiceImpl implements MovieDoubanService {

    @Autowired
    private MovieDoubanMapper movieDoubanMapper;

    /**
     * 豆瓣电影
     * 根据电影名称开头的字符串找出电影的基本资料
     *
     * @param keyword
     * @param offset
     * @param limit
     * @return
     */
    @Override
    @Cacheable
    public List<MovieDouban> getMovieDoubanListByNameStart(String keyword, int offset, int limit) {
        MovieDoubanExample example = new MovieDoubanExample();
        example.or().andNameZhLike(keyword + "%");
        PageHelper.startPage(offset, limit);
        return movieDoubanMapper.selectByExample(example);
    }
}
