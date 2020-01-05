package org.humingk.movie.server.auth.controller;

import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class TestController {

    @PostMapping("/test")
    public Result test() {
        return Result.success("test");
    }
}
