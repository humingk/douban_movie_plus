package org.humingk.movie.server.douban.controller;

import org.humingk.common.common.Result;
import org.humingk.movie.api.douban.SearchApi;
import org.humingk.movie.service.douban.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class SearchController implements SearchApi {

    @Autowired
    private SearchService searchService;

    /**
     * 豆瓣电影搜索提示
     * <p>
     * 根据电影名称开头的字符串找出豆瓣电影的基本信息列表
     *
     * @param keyword
     * @return
     */
    @Override
    @PostMapping("search_movie_tips")
    public Result searchMovieTips(@RequestParam("keyword") String keyword) {
        return Result.success(searchService.getMovieDoubanListByNameStart(keyword, 0, 10));
    }
}
