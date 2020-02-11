package org.humingk.movie.service.douban.service.impl;

import com.github.pagehelper.PageHelper;
import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.entity.MovieDoubanExample;
import org.humingk.movie.dal.mapper.auto.MovieDoubanMapper;
import org.humingk.movie.service.douban.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author humingk
 */
@Service
@RedisCache
public class SearchServiceImpl implements SearchService {
    @Autowired
    private MovieDoubanMapper movieDoubanMapper;

    @Override
    public List<MovieDouban> getMovieDoubanListByNameStart(String keyword, int offset, int limit) {
        MovieDoubanExample example = new MovieDoubanExample();
        example.or().andNameZhLike(keyword.trim() + "%");
        PageHelper.offsetPage(offset, limit);
        return movieDoubanMapper.selectByExample(example);
    }
}
