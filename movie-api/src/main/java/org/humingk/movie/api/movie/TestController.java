package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public Result test(@RequestParam("t") String t) {
        return Result.success(t);
    }
}
