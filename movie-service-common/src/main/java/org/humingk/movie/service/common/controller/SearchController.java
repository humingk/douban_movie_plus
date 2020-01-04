package org.humingk.movie.service.common.controller;

import org.humingk.movie.service.common.annotation.AesDecrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 搜索控制器
 *
 * @author humingk
 */
@RestController
@RequestMapping("/")
@AesDecrypt
public class SearchController {
//
//    @Autowired
//    private MovieDoubanService movieDoubanService;
//
//    /**
//     * 搜索提示框
//     *
//     * @param params
//     * @return
//     */
//    @RequestMapping(value = "search_tips", method = RequestMethod.POST)
//    public Result searchTips(@RequestParam String params) {
//        JSONObject jsonObject = JSON.parseObject(params);
//        return Result.success(movieDoubanService.getMovieDoubanListByNameStart(
//                jsonObject.getString("keyword"),
//                jsonObject.getInteger("offset"),
//                jsonObject.getInteger("limit")
//        ));
//    }
}
