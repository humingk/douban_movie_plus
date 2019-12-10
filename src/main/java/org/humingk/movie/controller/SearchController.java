package org.humingk.movie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.humingk.movie.annotation.AesDecrypt;
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
    @AesDecrypt
    public Result searchTips(@RequestParam("params") String params) {
        JSONObject jsonObject = JSON.parseObject(params);
        return new Result(200, "success",
                movieDoubanService.getMovieDoubanListByNameStart(
                        jsonObject.getString("keyword"),
                        jsonObject.getInteger("offset"),
                        jsonObject.getInteger("limit")
                )
        );
    }
}
