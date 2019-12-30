package org.humingk.douban.service;

import org.humingk.common.entity.MovieDouban;
import org.humingk.douban.entity.MovieDoubanDetail;


/**
 * 电影详情页
 *
 * @author humingk
 */
public interface SubjectService {

    /**
     * 根据豆瓣电影ID找出电影的基础信息
     *
     * @param id
     * @return
     */
    MovieDouban getMovieDoubanByDoubanId(int id);

    /**
     * 根据豆瓣电影ID找出电影的详细信息
     *
     * @param id
     * @return
     */
    MovieDoubanDetail getMovieDoubanDetailByDoubanId(int id);


}
