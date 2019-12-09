package org.humingk.movie.controller;

import org.humingk.movie.service.MovieDoubanService;
import org.humingk.movie.tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 搜索控制器
 *
 * @author humingk
 */
@RestController
@RequestMapping("/")
public class SearchController {

    @Autowired
    private MovieDoubanService movieDoubanService;

    /**
     * 搜索提示框
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "search_tips", method = RequestMethod.POST)
    public Result searchTips(@RequestParam("params") String params) {
        System.out.println(params);
        return null;
//        return new Result(200, "", movieDoubanService.getMovieDoubanListByNameStart(keyword, offset, limit));
    }
}
