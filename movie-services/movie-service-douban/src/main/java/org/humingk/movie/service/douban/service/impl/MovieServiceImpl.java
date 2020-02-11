package org.humingk.movie.service.douban.service.impl;

import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.mapper.auto.MovieDoubanMapper;
import org.humingk.movie.service.douban.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author humingk
 */
@Service
@RedisCache
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDoubanMapper movieDoubanMapper;

    @Override
    public MovieDouban getMovieDoubanByMovieDoubanId(long id) {
        return movieDoubanMapper.selectByPrimaryKey(id);
    }
}
