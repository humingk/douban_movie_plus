package org.humingk.movie.server.douban.controller;

import org.humingk.common.entity.MovieDouban;
import org.humingk.movie.api.douban.api.SearchApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author humingk
 */
@RestController
public class SubjectController implements SearchApi {

    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出电影的基本信息列表
     *
     * @param params
     * @return
     */
    @Override
    @PostMapping("search_movie_tips")
    public List<MovieDouban> searchMovieTips(String params) {
        return null;
    }
}
