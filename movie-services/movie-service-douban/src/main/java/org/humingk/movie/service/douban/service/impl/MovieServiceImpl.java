package org.humingk.movie.service.douban.service.impl;

import org.humingk.movie.common.annotation.RedisCache;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.humingk.movie.dal.entity.AliasMovieDoubanExample;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.mapper.auto.AliasMovieDoubanMapper;
import org.humingk.movie.dal.mapper.auto.MovieDoubanMapper;
import org.humingk.movie.service.douban.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author humingk
 */
@Service
@RedisCache
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDoubanMapper movieDoubanMapper;
    @Autowired
    private AliasMovieDoubanMapper aliasMovieDoubanMapper;

    @Override
    public MovieDouban getMovieDoubanByMovieDoubanId(long id) {
        return movieDoubanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AliasMovieDouban> getAliasMovieDoubanListByMovieDoubanId(long id) {
        AliasMovieDoubanExample example = new AliasMovieDoubanExample();
        example.or().andIdMovieDoubanEqualTo(id);
        return aliasMovieDoubanMapper.selectByExample(example);
    }
}
