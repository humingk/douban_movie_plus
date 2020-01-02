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

}
