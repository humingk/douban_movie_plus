package org.humingk.movie.service.douban.service;

import org.humingk.movie.dal.entity.MovieDouban;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author humingk
 */
@Validated
public interface MovieService {

    /**
     * 获取豆瓣电影基础信息
     *
     * @param id 豆瓣电影ID
     * @return
     */
    @NotNull(message = "该ID暂无对应电影")
    MovieDouban getMovieDoubanByMovieDoubanId(long id);


}
