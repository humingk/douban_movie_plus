package org.humingk.movie.service.common.controller;

import org.humingk.movie.service.common.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author humingk
 */
@RestController
public class IndexController {
    /**
     * 网站首页
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Result index() {
        return Result.success("index page");
    }
}
